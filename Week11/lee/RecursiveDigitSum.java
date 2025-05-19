package RecursiveDigitSum;

class Result {
    public static long recursive(String n) {
        long p = 0;
        for (char i: n.toCharArray()) {
            p += i - '0';
        }
        if (p < 10)
            return p;
        return recursive(Long.toString(p));
    }

    public static int superDigit(String n, int k) {
        long p = 0;
        for (char i: n.toCharArray()) {
            p += i - '0';
        }
        p = p * k;
        return (int) recursive(Long.toString(p));
    }
}

public class RecursiveDigitSum {
    public static void main(String[] args) {
        System.out.println(Result.superDigit("9875", 4));
    }
}
