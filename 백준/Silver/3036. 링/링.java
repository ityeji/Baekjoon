import java.util.Scanner;

public class Main {

	// 최대 공약수로 나누기!
	// 유클리드 호제법
	// 1. 두 개의 수 중 큰 수를 찾고
	// 2. 큰 수를 작은 수로 나누어서 나머지 찾고
	// 3. 또 앞에서 나눈 수(작은 수)를 나머지로 나눠서 나머지 구하고
	// 4. 위의 과정 반복
	// 5. 나머지가 0이되면 -> 그 시점에 나눈 수가 최대 공약수
	// 반복해야하니까 재귀 돌릴래!

	public static int solved(int max, int min) {
		int na = max % min;
		if (na == 0) { // 나머지가 0이면 최소값 반환
			return min;
		} else {
			return solved(min, na); // 나머지가 0이 아니면 전 최소값를 나머지로 나눠줘야함.
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();

		// 입력값 받을 배열
		int[] input = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		for (int i = 1; i < n; i++) {
			int num = solved(input[0], input[i]);
			sb.append(input[0] / num);
			sb.append("/");
			sb.append(input[i] / num + "\n");
		}

		System.out.println(sb);

	}

}