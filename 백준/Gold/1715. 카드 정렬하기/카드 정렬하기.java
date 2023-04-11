import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	// 순서가 작은 것부터 먼저 더해주어야 가장 작은 값이 나옴
	// 그래서 우선순위큐를 사용해준다!
	// 만약, 10 15 20 22면,
	// 10 + 15 = 25로, 뒤에 있는 20, 22보다 수가 커지는데
	// 이럴 경우, 뒤에 있는 20 22를 먼저 더해야한다.
	// 두 개를 합친 경우든, 아직 합치지 않은 한 개의 경우든,
	// 작은 수들끼리부터 더해줘야 최소 값이 나온다.
	// 그래서, 더한 값을 다시 우선순위큐에 넣어줘야한다.

	static Scanner sc = new Scanner(System.in);

	static PriorityQueue<Integer> pq;
	static int n;
	static int result;
	static int[] sums;

	public static void input() {

		n = sc.nextInt();
		pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.offer(sc.nextInt());
		}
		result = 0;
		sums = new int[n - 1];

	}

	public static void solve() {

		if (pq.size() == 1)
			return; // 카드 묶음이 하나라면, 비교를 할 수 없으니 result = 0

		int idx = 0;
		while (true) {
			int num = pq.poll() + pq.poll();
			sums[idx++] = num;

			if (pq.isEmpty()) {
				break;
			}

			pq.offer(num);

		}

		for (int i = 0; i < n - 1; i++) {
			result += sums[i];
		}
	}

	public static void main(String[] args) {

		input();
		solve();
		System.out.println(result);

	}

}