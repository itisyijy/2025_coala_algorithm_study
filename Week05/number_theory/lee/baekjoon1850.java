/*
MEM:    41388KB
TIME:   320ms
*/

import java.util.Scanner;

public class baekjoon1850 {
    public static long gcd(long big, long small) {
        if (big % small == 0)
            return small;
        return gcd(small, big % small);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long gcd = gcd(Math.max(a, b), Math.min(a, b));

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < gcd; i++)
            result.append("1");
        System.out.println(result.toString());
    }
}
