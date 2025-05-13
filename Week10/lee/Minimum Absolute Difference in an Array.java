import java.io.*;
import java.util.*;

class Result {
  public static int minimumAbsoluteDifference(List<Integer> arr) {
    // Write your code here
    int answer = Integer.MAX_VALUE;
    arr.sort(Comparator.naturalOrder());
    for (int i = 0; i < arr.size() - 1; i++) {
      int gap = Math.abs(arr.get(i) - arr.get(i + 1));
      if (answer > gap) {
        answer = gap;
      }
    }
    return answer;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    Integer[] arr = {3, -7, 0};
    List<Integer> list = Arrays.asList(arr);
    System.out.println(Result.minimumAbsoluteDifference(list));
  }
}
