import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {

    ArrayList<String> operations = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Stack<Integer> stack = new Stack<>();
    int num = 0;
    stack.push(num);

    int length = scanner.nextInt();
    for (int i = 0; i < length; i++) {
      int item = scanner.nextInt();
      while (item > stack.peek()) {
        stack.push(++num);
        operations.add("+");
      }
      if (item == stack.peek()) {
        stack.pop();
        operations.add("-");
      }
      else if (item < stack.peek()) {
        System.out.println("NO");
        return ;
      }
    }
    for (String ops: operations) {
      System.out.println(ops);
    }
  }
}