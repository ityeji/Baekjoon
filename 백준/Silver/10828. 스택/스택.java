import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String s = sc.next();

			switch (s) {
			case "push":

				int num = sc.nextInt();

				stack.push(num);

				break;

			case "top":
				if (stack.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(stack.peek() + "\n");
				}

				break;

			case "size":
				sb.append(stack.size() + "\n");
				break;

			case "empty":
				if (stack.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}

				break;

			case "pop":
				if (stack.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(stack.pop() + "\n");
				}

				break;
			}

		}

		System.out.println(sb);

	}

}