import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐에서 큰 숫자부터 나오게 하려면?
		// Collections.reverseOrder()를 써야한다.
		// 기본은 작은 숫자부터!

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();

			if (x == 0) {
				if (pq.isEmpty()) {
					sb.append(x + "\n");
				} else {
					sb.append(pq.poll() + "\n");

				}
			} else {
				pq.add(x);
			}
		}

		System.out.println(sb);

	}

}