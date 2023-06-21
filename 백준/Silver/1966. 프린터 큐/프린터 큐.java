import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			LinkedList<int[]> queue = new LinkedList<>(); // 밑에서 원소를 get해야하므로 queue는 못씀(get이 없음)
			// 문서 순서와 중요도룰 함께 나타내야하므로 int[]를 쓴다.
			int n = sc.nextInt();
			int m = sc.nextInt();

			for (int j = 0; j < n; j++) {
				queue.offer(new int[] { j, sc.nextInt() });
			}

			int count = 0;

			while (!queue.isEmpty()) {
				int[] front = queue.poll();

				boolean isMax = true; // front 원소가 가장 중요도가 높은 변수인지 체크

				// 뒤의 원소들 돌아가면서 front와 비교
				for (int k = 0; k < queue.size(); k++) {

					// front보다 중요도 큰 원소 발견!
					// front와 해당 원소 앞의 원소들 싹다 offer해서 해당 원소보다 뒤에 배치하기
					if (front[1] < queue.get(k)[1]) {
						queue.offer(front);
						for (int j = 0; j < k; j++) {
							queue.offer(queue.poll());
						}

						// front가 가장 큰 원소가 아니었어!
						isMax = false;
						break;
					}
				}

				if (!isMax) {
					continue;
				}

				// 여기로 내려왔다는 것은?
				// isMax가 false라는 소리!
				count++;
				if (front[0] == m) {
					// 찾고자 하는 문서와 같아!
					break;
				}
			}

			sb.append(count + "\n");
		}

		System.out.println(sb);
	}

}