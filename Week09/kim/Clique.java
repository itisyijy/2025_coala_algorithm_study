import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int clique(int n, int m) {
        int low = 1;
        int high = n;
        int ans = 1;

        while (low <= high) {
            int mid = (low + high) / 2; // 클리키 후보: 중간값 
            int t = turan(n, mid - 1); // t: mid가 생기지 않는 최대 간선 수

            if (t <= m) { // 간선 수 많음 -> 클리키 무조건 생김 
                ans = mid; 
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }

        return ans; // 항상 생기는 최대 클리키의 최소 크기
    }

    
    public static int turan(int n, int r) {
        if (r == 0) return 0; 
        int q = n / r;
        int rem = n % r;

        return (r - rem) * q * (q - 1) / 2 + rem * q * (q + 1) / 2; 
    }
} 


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            int result = Result.clique(n, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
