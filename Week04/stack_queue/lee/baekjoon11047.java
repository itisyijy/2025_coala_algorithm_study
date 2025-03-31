import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int coinType = scanner.nextInt(); // 동전의 종류 개수
    int target = scanner.nextInt();   // 목표 금액
    int coinUsage = 0;                // 사용한 동전의 개수
    Stack<Integer> coins = new Stack<>(); // 각 동전 액면가

    // coins 초기화
    for (int i = 0; i < coinType; i++)
      coins.push(scanner.nextInt());

    while (target > 0) {
      int coin = coins.pop();
      if (target / coin > 0) {      // 목표 금액을 coin으로 일부 표현이 가능한 경우
        coinUsage += target / coin; // 남은 목표 금액에서 coin 사용 개수 누적
        target = target % coin;     // coin 사용 후 남은 금액 최신화
      }
    }
    System.out.println(coinUsage);
  }
}