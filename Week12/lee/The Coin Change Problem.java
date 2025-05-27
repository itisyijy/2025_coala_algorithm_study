import java.io.*;
import java.util.*;

class Result {
  public static long getWays(int n, List<Long> c) {
    // ways[i] = number of ways for making "i" using given coins from c
    long[] ways = new long[n + 1];
    c.sort(Comparator.naturalOrder());
    ways[0] = 1;

    for (long coin: c) {
      for (int i = (int) coin; i <= n; i++) {
        ways[i] += ways[i - (int) coin];
      }
    }
    return ways[n];
  }
}
public class Solution {
  public static void main(String[] args) throws IOException {
    int n = 10;
    long[] arr = {2, 5, 3, 6};
    ArrayList<Long> c = new ArrayList<>();
    for (long val : arr) {
      c.add(val); // auto-boxes long to Long
    }
    System.out.println(Result.getWays(n, c));
  }
}
