import java.util.Scanner;

public class Main {

	// 재귀로도 풀 수 있고
	// DP로도 풀 수 있고!!!

	// 이건 재귀 버전!

	static int n;
	static int[][] coun;
	static int max; // 결과값

	public static void DFS(int idx, int pay) {
		if (idx >= n) {
			max = Integer.max(max, pay);
			return;
		}

		if (idx + coun[idx][0] <= n) { // 만약, 0번 인덱스(1일의 상담 일수)가 7이면 -> 간당하게 n일동안 상담함. 고로, 다음 상담은 진행할 수 없음.
			// 그래서 idx+1을 안해도 되는 것
			DFS(idx + coun[idx][0], pay + coun[idx][1]); // 지금까지 넘어온 금액에 지금 진행하는 상담의 금액 적기
		} else {
			DFS(idx + coun[idx][0], pay); // 만약, n을 넘어가!
			// 그러면, 지금 걸려있는 상담은 진행 못하자나
			// 금액은 넘겨주지 말고, 날짜만 넘겨줘서 기저조건에 걸리게 해 result 뽑아내자
		}

		// 지금 걸려있는 상담을 진행하지 않고, 다음 상담으로 넘어갈 수도 있잖아?
		DFS(idx + 1, pay);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		coun = new int[n][2]; // 0열은 며칠걸리는지? 1열은 금액

		for (int i = 0; i < n; i++) {
			coun[i][0] = sc.nextInt();
			coun[i][1] = sc.nextInt();
		}

		max = 0;

		DFS(0, 0); // 1일(idx로 접근할 거니까, 0번 인덱스 == 1일), 금액 0원부터 시작

		System.out.println(max);

	}

}