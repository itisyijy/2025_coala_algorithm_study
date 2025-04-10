import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'journeyToMoon' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. 2D_INTEGER_ARRAY astronaut
   */

  public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
    // Write your code here

    // Initialize Graph
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++)
      graph.add(new ArrayList<>());

    // Make Edges For Link Nodes
    for (List<Integer> astronautPair: astronaut) {
      graph.get(astronautPair.get(0)).add(astronautPair.get(1));
      graph.get(astronautPair.get(1)).add(astronautPair.get(0));
    }

    //
    int result = n * (n - 1) / 2;
    System.out.println(result);
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      int count = dfs(i, visited,graph);
      result -= count * (count - 1) / 2;
    }
    System.out.println(result);
    return result;
  }

  // DFS
  public static int dfs(int node,boolean[] visited, List<List<Integer>> graph) {
    visited[node] = true;
    int count = 1;

    for (int neighbor: graph.get(node))
      if (!visited[neighbor])
        count += dfs(neighbor, visited, graph);

    return count;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int p = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> astronaut = new ArrayList<>();

    IntStream.range(0, p).forEach(i -> {
      try {
        astronaut.add(
            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    int result = Result.journeyToMoon(n, astronaut);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
