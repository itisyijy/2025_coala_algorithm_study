import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {
                int absA = Math.abs(a);
                int absB = Math.abs(b);

                if (absA == absB) {
                    return a - b;  // 실제 값 비교
                }
                return absA - absB;  // 절댓값 비교
            }
        });

        int N = scanner.nextInt();

        for (int i = 0; i<N; i++) {
            int z = scanner.nextInt();
            if (z != 0) {
                pq.add(z);
            } else {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            }
        }

    }
}