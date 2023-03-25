import java.util.Scanner;
import java.util.Stack;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static StringBuilder sb = new StringBuilder();

	static Stack<Integer> nums = new Stack<>();

	public static void main(String[] args) {

		int t = sc.nextInt();

		int start = 0; // 스택에 아무것도 안쌓여있는 상태

		for (int tc = 0; tc < t; tc++) {

			int num = sc.nextInt();

			if (start < num) {
				for (int i = start + 1; i <= num; i++) { // 1부터 오름차순으로 쌓아야하니까
					nums.push(i);
					sb.append("+\n");
				}
				start = num; //
			}
			
			else if (nums.peek() != num) {
				System.out.println("NO");
				return;
			}

			nums.pop();
			sb.append("-\n");


		}

		System.out.println(sb);

	}

}