import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();

        for (int num = M ; num <= N ; num++) {
            if (isPrime(num)) {
                System.out.println(num);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i =2; i <= Math.sqrt(n); i++) {
            if (n % i ==0) return false;
        }

        return true;
    }
}