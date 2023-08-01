import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Deque<Integer> deque = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String s = sc.next();

			if (s.equals("push_front")) {
				int num = sc.nextInt();
				deque.addFirst(num);
			} else if (s.equals("push_back")) {
				int num = sc.nextInt();
				deque.addLast(num);
			} else if (s.equals("pop_front")) {
				if (deque.isEmpty()) {
					sb.append("-1" + "\n");
				} else {
					sb.append(deque.pollFirst() + "\n");
				}
			} else if (s.equals("pop_back")) {
				if (deque.isEmpty()) {
					sb.append("-1" + "\n");
				} else {
					sb.append(deque.pollLast() + "\n");
				}
			} else if (s.equals("size")) {
				sb.append(deque.size() + "\n");
			} else if (s.equals("empty")) {
				if (deque.isEmpty()) {
					sb.append("1" + "\n");
				} else {
					sb.append("0" + "\n");
				}
			} else if (s.equals("front")) {
				if (deque.isEmpty()) {
					sb.append("-1" + "\n");
				} else {
					sb.append(deque.peekFirst() + "\n");
				}
			} else {
				if (deque.isEmpty()) {
					sb.append("-1" + "\n");
				} else {
					sb.append(deque.peekLast() + "\n");
				}
			}

		}

		System.out.println(sb);

	}

}