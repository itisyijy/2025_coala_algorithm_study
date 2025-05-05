//Hackerrank Breadth First Search: Shortest Reach
import java.util.*;
class Result {

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] distances = new int[n+1];
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        distances[s] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : graph.get(curr)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[curr] + 6;
                    queue.offer(neighbor);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i =1; i <= n; i++) {
            if (i != s) {
                result.add(distances[i]);
            }
        }
        return result;
    }
}

