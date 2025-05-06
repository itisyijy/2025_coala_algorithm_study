class Result {
    public static int clique(int n, int m) {
    // Write your code here
    int left_k = 2;
    int right_k = n + 1;
    int answer = 2;

    while (left_k <= right_k) {
        int mid_k = (left_k + right_k) / 2;
        long maxEdge = ((long) (mid_k - 1) * n * n) / (2L * mid_k);

        if (m <= maxEdge) {
            answer = mid_k;
            right_k = mid_k - 1;
        }
        else{
            left_k = mid_k + 1;
        }
    }
    return answer;
    }
}

public class Clique {
    public static void main(String[] args) {
        System.out.println(Result.clique(3, 2));
        System.out.println(Result.clique(4, 6));
        System.out.println(Result.clique(5, 7));
    }
}