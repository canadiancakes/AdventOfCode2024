import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Day1 {
  public static void main(String[] args) {
    
    PriorityQueue<Integer> leftList = new PriorityQueue<>();
    PriorityQueue<Integer> rightList = new PriorityQueue<>();
    ArrayList<Integer> distances = new ArrayList<Integer>();

    try {
        File myObj = new File("input.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String ids = myReader.nextLine();
          String[] splitids = ids.split("   ");
          int l = Integer.valueOf(splitids[0]);
          int r = Integer.valueOf(splitids[1]);
          leftList.add(l);
          rightList.add(r);
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }

      while (leftList.peek() != null){
        int lmin = leftList.poll();
        int rmin = rightList.poll();
        int temp = lmin - rmin;
        int dist = Math.abs(temp);
        distances.add(dist);
      }

      int sum = 0;
      for (int i = 0; i < distances.size(); i++){
        sum = sum + distances.get(i);
      }

      System.out.println("Part 1");
      System.out.println(sum);
      System.out.println();
        
      System.out.println("Part 2");

    PriorityQueue<Integer> leftL = new PriorityQueue<>();
    PriorityQueue<Integer> rightL = new PriorityQueue<>();
    long similarityScore = 0;

    try {
        File myObj = new File("input.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String ids = myReader.nextLine();
          String[] splitids = ids.split("   ");
          int l = Integer.valueOf(splitids[0]);
          int r = Integer.valueOf(splitids[1]);
          leftL.add(l);
          rightL.add(r);
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }

      int count = 0;
      while (leftL.peek() != null && rightL.peek() != null){
        int lv = leftL.peek();
        int rv = rightL.peek();
        if (lv < rv){
            int temp = leftL.poll();
            similarityScore = similarityScore + (temp * count);
            while (leftL.peek() != null){
                int lvtemp = leftL.peek();
                if (lvtemp == temp){
                    similarityScore = similarityScore + (temp * count);
                    leftL.poll();
                } else {
                    break;
                }
            }
            count = 0;
        }
        else if (lv == rv){
            count++;
            rightL.poll();
        }
        else if (lv > rv){
            rightL.poll();
        }
      }

      System.out.println(similarityScore);
  }
}