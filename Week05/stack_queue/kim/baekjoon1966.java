import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static class Document {
        int index;     // 문서 번호
        int priority;  // 중요도

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = sc.nextInt(); // 문서 개수
            int M = sc.nextInt(); // 궁금한 문서 위치

            Queue<Document> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                int priority = sc.nextInt();
                queue.add(new Document(i, priority));
            }

            int order = 0; // 출력 순서 세기

            while (!queue.isEmpty()) {
                Document current = queue.poll();

                // 현재 문서보다 더 중요한 게 뒤에 있는지?
                boolean hasHigher = false;
                for (Document d : queue) {
                    if (d.priority > current.priority) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    queue.add(current); // 뒤로 보냄
                } else {
                    order++; // 출력 순서 증가
                    if (current.index == M) {
                        System.out.println(order); // 내가 찾던 문서라면 출력!
                        break;
                    }
                }
            }
        }
    }
}
