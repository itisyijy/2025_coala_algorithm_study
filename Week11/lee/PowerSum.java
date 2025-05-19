package PowerSum;

class Result {
    public static int recursive(int remain, int power, int start) {
        // exit condition
        if (remain == 0)
            return 1; // find powerSum
        if (remain < 0)
            return 0; // cannot find powerSum

        int total = 0;
        for (int i = start; Math.pow(i, power) <= remain; i++) {
            total += recursive(remain - (int) Math.pow(i, power), power, i + 1);
        }

        // all possible case
        return total;
    }

    public static int powerSum(int X, int N) {
        return recursive(X, N, 1);
    }
}


public class PowerSum {
    public static void main(String[] args) {
        System.out.println(Result.powerSum(100, 2));
    }
}