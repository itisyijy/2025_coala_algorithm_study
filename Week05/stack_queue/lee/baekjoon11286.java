/*
TEST INFO:
MEM: 103584 KB
TIME: 1020ms
*/

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> absHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2))
                    return o1 - o2;
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        Scanner scanner = new Scanner(System.in);
        int numOfOps = scanner.nextInt();

        for (int i = 0; i < numOfOps; i++) {
            int info = scanner.nextInt();
            if (info == 0) {
                Integer absMin = absHeap.poll();
                if (absMin == null)
                    System.out.println(0);
                else
                    System.out.println(absMin);
            }
            else {
                absHeap.offer(info);
            }
        }
    }
}