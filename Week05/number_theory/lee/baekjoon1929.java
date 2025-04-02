/*
MEM:  35804KB
TIME: 796ms
*/

import java.util.Scanner;

public class baekjoon1929 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int rangeMin = scanner.nextInt();
    int rangeMax = scanner.nextInt();
    boolean[] isPrime = new boolean[rangeMax + 1];
    for (int i = 2; i <= rangeMax; i++)
      isPrime[i] = true;

    // i < root(rangeMax)
    for (int i = 2; i * i < rangeMax; i++)
      if (isPrime[i])
        for (int j = i * i; j <= rangeMax; j += i)
          isPrime[j] = false;

    for (int i = rangeMin; i <= rangeMax; i++)
      if (isPrime[i]) {
        System.out.println(i);
      }
  }
}
