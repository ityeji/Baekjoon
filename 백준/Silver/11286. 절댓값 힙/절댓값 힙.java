import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// 음수면 자리 그대로
				// 양수면 자리 바꿈
				if (Math.abs(o1) > Math.abs(o2)) {
					// 절대값 기준으로 앞 값이 더 크면 자리 바꿔줌
					return Math.abs(o1) - Math.abs(o2);
				} else if (Math.abs(o1) == Math.abs(o2)) {
					// 두 값이 같다면 음수 앞으로
					return o1 - o2;
				} else {
					return -1;
				}
			}

		});

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();

			if (x == 0) {
				if (pq.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			} else {
				pq.offer(x);
			}
		}

		System.out.println(sb);

	}

}