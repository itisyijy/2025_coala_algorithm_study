import java.util.Scanner;

public class Main {
    public static long gcd(long a, long b) {
        if (b == 0) return a; //나머지가 0이 되면 
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        long g = gcd(A, B); // 반복 횟수 = 최대공약수

        // "1"을 g번 반복해서 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < g; i++) {
            sb.append("1");
        }

        System.out.println(sb.toString());
    }
}

