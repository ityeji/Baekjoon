import java.util.Scanner;

public class Main {

	// 나는 방문체크를 이용한 순열로 풀이할 거지롱

	static Scanner sc = new Scanner(System.in);

	static int n; // 1~n까지의 수로 이루어진 순열을 출력하자!

	static int[] nums; // 1~n까지의 수를 배열에 저장

	static boolean[] visited; // 방문체크

	static int[] result;

	public static void input() {
		n = sc.nextInt();

		nums = new int[n];

		// 1부터 n까지 nums배열에 넣어주기
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		visited = new boolean[n];

		result = new int[n];
	}

	public static void permutation(int idx) {

		// basecase
		if (idx == n) {
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					System.out.print(result[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		// recursive case
		for (int i = 0; i < n; i++) {

			// 이미 결과에 포함된 원소는 다시 포함시키면 안되니까
			// 이부분은 절대 잊지 말자!
			if (visited[i]) {
				continue;
			}

			result[idx] = nums[i];
			visited[i] = true; // 사용함 체크 해주고
			permutation(idx + 1); // 사용했으니 인덱스 하나 들려주고
			visited[i] = false; // 순서 바꿔서 사용해도 서로 다른 값으로 유효하니까...
		}
	}

	public static void main(String[] args) {

		input();
		permutation(0);

	}

}