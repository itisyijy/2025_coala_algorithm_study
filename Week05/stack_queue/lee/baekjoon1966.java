import java.util.LinkedList;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfTest = scanner.nextInt();
        for (int i = 0; i < numOfTest; i++) {

            int length = scanner.nextInt();
            int targetIndex = scanner.nextInt();

            LinkedList<int[]> queue = new LinkedList<>();
            for (int j = 0; j < length; j++)
                queue.offer(new int[]{scanner.nextInt(), j});

            int count = 1;
            while (!queue.isEmpty()) {
                int[] front = queue.peek();
                boolean isMax = true;

                for (int j = 0; j < queue.size(); j++)
                    if (front[0] < queue.get(j)[0]) {
                        isMax = false;
                        queue.offer(queue.poll());
                        break;
                    }
                if (isMax) {
                    if (front[1] == targetIndex) {
                        System.out.println(count);
                        break;
                    }
                    queue.poll();
                    count++;
                }
            }

        }
    }
}
