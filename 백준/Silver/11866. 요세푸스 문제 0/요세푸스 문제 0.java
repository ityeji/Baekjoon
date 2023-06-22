import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();

		int k = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		sb.append("<");

		while (queue.size() > 1) {
			for (int i = 0; i < k - 1; i++) {
				int num = queue.poll();
				queue.offer(num);
			}
			sb.append(queue.poll() + ", ");
		}

		sb.append(queue.poll() + ">");

		System.out.println(sb);
	}

}