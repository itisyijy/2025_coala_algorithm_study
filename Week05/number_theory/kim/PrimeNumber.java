package week2.NumberAlgorithm;

import java.util.Scanner;

//[1929] 소수 구하기

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();  //구간 [M,N]
        int N = sc.nextInt();
        int[] A= new int[N+1];
        A[0] =0;  // 생략 가능
        A[1] =0;  // 생략 가능

        for (int i=2; i<=N; i++) {
            A[i] = i;
        }
        for (int i=1; i<=Math.sqrt(N); i++) {  //숫자 1 생략하기 위해
            if (A[i]==0)
                continue;
            for (int j = i *2 ; j <=N; j+=i) {  //소수의 배수 지우기
                A[j] = 0;
            }
        }
        for (int i =M; i<=N; i++) {
            if (A[i]!=0) {
                System.out.println(A[i]);
            }
        }
    }
}