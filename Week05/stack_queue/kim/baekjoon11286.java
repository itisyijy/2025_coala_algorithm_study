import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
        int absA = Math.abs(a);
        int absB = Math.abs(b);

        if (absA == absB) {
            return a - b; //절댓값 같으면 작은 순서부터
        } else {
            return absA - absB; //절댓값 작은 순서부터
        }
    });

    for (int i=0; i <N; i++) {
        int x = sc.nextInt();

        if (x==0) {
            if (pq.isEmpty()) {
                System.out.println(0);
            } else { //큐에 값이 있으면
                System.out.println(pq.poll()); //큐에서 우선순위 높은 값 꺼내서 출력
            }
        } else {
            pq.add(x); //숫자를 큐에 추가
        }
    }
    }
}
