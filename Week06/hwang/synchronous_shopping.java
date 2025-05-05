import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'shop' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. STRING_ARRAY centers
     *  4. 2D_INTEGER_ARRAY roads
     */

    public static int shop(int n, int k, List<String> centers, List<List<Integer>> roads) {
        // Write your code here
        int[] fishAtCenter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String[] items = centers.get(i).split(" ");
            int fishMask = 0;
            for (int j = 1; j < items.length; j++) {
                int fishType = Integer.parseInt(items[j]);
                fishMask |= (1 << (fishType - 1)); // 물고기 종류를 비트로 마킹
            }
            fishAtCenter[i + 1] = fishMask;
        }

        // 2. 그래프 만들기 (인접 리스트)
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> road : roads) {
            int u = road.get(0);
            int v = road.get(1);
            int time = road.get(2);
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        // 3. 다익스트라 준비 (dist[노드번호][물고기상태] = 시간)
        int[][] dist = new int[n + 1][1 << k];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int startFish = fishAtCenter[1];
        dist[1][startFish] = 0;
        pq.offer(new int[]{0, 1, startFish}); // {시간, 노드번호, 물고기상태}

        // 4. 다익스트라 실행
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0];
            int u = cur[1];
            int fishMask = cur[2];

            if (dist[u][fishMask] < time) continue;

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int cost = edge[1];
                int newFishMask = fishMask | fishAtCenter[v];
                int newTime = time + cost;

                if (dist[v][newFishMask] > newTime) {
                    dist[v][newFishMask] = newTime;
                    pq.offer(new int[]{newTime, v, newFishMask});
                }
            }
        }

        // 5. 최종 목적지(n)에서 가능한 모든 물고기 상태 조합 중 최소값 찾기
        int minTime = Integer.MAX_VALUE;
        int allFish = (1 << k) - 1;

        for (int i = 0; i < (1 << k); i++) {
            for (int j = 0; j < (1 << k); j++) {
                if ((i | j) == allFish) {
                    int maxTime = Math.max(dist[n][i], dist[n][j]);
                    minTime = Math.min(minTime, maxTime);
                }
            }
        }

        return minTime;
    }

}

public class synchronous_shopping {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        List<String> centers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String centersItem = bufferedReader.readLine();
            centers.add(centersItem);
        }

        List<List<Integer>> roads = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] roadsRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> roadsRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int roadsItem = Integer.parseInt(roadsRowTempItems[j]);
                roadsRowItems.add(roadsItem);
            }

            roads.add(roadsRowItems);
        }

        int res = Result.shop(n, k, centers, roads);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}