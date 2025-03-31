import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String expression = scanner.next();
    
    // "-"부터 다음 "-" 사이의 숫자를 모두 괄호로 묶기
    String[] nums = expression.split("-");

    // nums[0]
    int tmp = 0;
    for (String n: nums[0].split("\\+"))
      tmp += Integer.parseInt(n);
    int min = tmp;

    // nums[1:]
    for (int i = 1; i < nums.length; i++) {
      tmp = 0;
      for (String n: nums[i].split("\\+"))
        tmp += Integer.parseInt(n);
      min -= tmp;
    }
    System.out.println(min);
  }
}