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
     * Complete the 'clique' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int clique(int n, int m) {
        for (int k = 1; k <= n; k++) {
            long maxEdgesWithoutK = turan(n, k - 1);  // no clique of size k
            if (m > maxEdgesWithoutK) {
                return k;
            }
        }
        return n; // worst case
    }

    private static long turan(int n, int r) {
        if (r == 0) return 0;
        int q = n / r;
        int rem = n % r;

        long maxEdges = 0;
        // r parts: some of size q, some of size q+1
        // total pairs = sum_{i<j} |Vi||Vj| = total possible edges between parts
        for (int i = 0; i < r; i++) {
            int sizeI = q + (i < rem ? 1 : 0);
            for (int j = i + 1; j < r; j++) {
                int sizeJ = q + (j < rem ? 1 : 0);
                maxEdges += (long) sizeI * sizeJ;
            }
        }
        return maxEdges;
    }
}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.clique(n, m);

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
