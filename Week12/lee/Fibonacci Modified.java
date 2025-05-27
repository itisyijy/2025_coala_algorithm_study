import java.io.*;
import java.math.BigInteger;

class Result {

  public static BigInteger fibonacciModified(int t1, int t2, int n) {
    BigInteger[] seq = new BigInteger[n];
    seq[0] = BigInteger.valueOf(t1);
    seq[1] = BigInteger.valueOf(t2);

    for (int i = 2; i < n; i++) {
      seq[i] = seq[i - 2].add(seq[i - 1].multiply(seq[i - 1]));
    }

    return seq[n - 1];
  }

}
public class Solution {
  public static void main(String[] args) throws IOException {
    int t1 = 0;
    int t2 = 1;
    int n = 10;
    System.out.println(Result.fibonacciModified(t1, t2, n));
  }
}
