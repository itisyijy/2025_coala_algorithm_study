import java.io.*;
import java.util.Arrays;


class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        String[] input=br.readLine().split(" ");
        int M=Integer.parseInt(input[0]);
        int N=Integer.parseInt(input[1]);

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        // 에라토스테네스의 체
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) { //i의 배수 제거
                    isPrime[j] = false;
                }
            }
        }

        // M부터 N까지 중에서 소수인 것만 출력
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb); // 한번에 출력
    }
}