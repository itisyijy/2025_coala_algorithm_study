import java.io.*;
import java.util.*;

class Result {
  public static long marcsCakewalk(List<Integer> calorie) {
    // Write your code here
    long mileage = 0;

    calorie.sort((a, b) -> b - a);
    for (int i = 0; i < calorie.size(); i++) {
      mileage += calorie.get(i) * (1L << i);
    }
    return mileage;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    Integer[] arr = {7, 4, 9, 6};
    List<Integer> list = Arrays.asList(arr);
    System.out.println(Result.marcsCakewalk(list));
  }
}
