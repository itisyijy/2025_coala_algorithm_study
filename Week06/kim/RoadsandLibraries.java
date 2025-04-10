import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */


    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here

        if (c_road >= c_lib) {
            return (long) n * c_lib;  //모든 도시에 도서관 짓기
        }

       
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());  //각 도시마다 연결 리스트 준비
        }

        //주어진 도로 정보로 양방향 그래프 만들기
        for (List<Integer> edge : cities) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);  //u->v
            graph.get(v).add(u);  //v->u
        }

        boolean[] visited = new boolean[n + 1]; 
        long totalCost = 0;

      
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                int componentSize = dfs(i, graph, visited); // DFS로 이 도시와 연결된 컴포넌트의 도시 수 구하기

                long cost1 = (long) componentSize * c_lib;  // ① 이 컴포넌트의 모든 도시에 도서관만 짓는 경우
                long cost2 = (long) (componentSize - 1) * c_road + c_lib;  // ② 도서관 하나 + 나머지는 도로로 연결하는 경우

                
                totalCost += Math.min(cost1, cost2);
            }
        }

        return totalCost;
    }

    // 연결된 컴포넌트의 크기를 DFS로 구해주는 함수
    private static int dfs(int start, List<List<Integer>> graph, boolean[] visited) {
        // 탐색할 도시들을 쌓아둘 스택
        Stack<Integer> stack = new Stack<>();

        // 시작 도시는 바로 방문 체크 & 스택에 추가
        stack.push(start);
        visited[start] = true;

        // 연결된 도시 개수 (시작 도시 포함하니까 1부터 시작)
        int size = 1; 

        // 스택이 빌 때까지 반복 (= 연결된 모든 도시 다 탐색할 때까지)
        while (!stack.isEmpty()) {
            // 현재 탐색할 도시 하나 꺼냄
            int current = stack.pop();

            // 현재 탐색할 도시 하나 꺼냄
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {   // 아직 방문 안 했으면
                    visited[neighbor] = true;  // 방문 체크하고
                    stack.push(neighbor);  // 나중에 탐색할 수 있도록 스택에 추가
                    size++;   // 연결된 도시 수 하나 추가
                }
            }
        }

        // 최종적으로 연결된 컴포넌트 크기 반환
        return size;
    }
}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
