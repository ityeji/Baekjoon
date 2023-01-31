
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		// for문 돌려서 완전 제곱수 합을 구하고
		// 최소값 찾기
		// 완전제곱수가 없으면 -> -1 출력

		int sum = 0;

		// Math.sqrt() -> 자바 루트 구하기

		int min = n; // 초기 최소값을 최대값으로 잡고
		// 아무리 제곱을 해도 n보다는 크지 못한다.

		// for문 돌려서 완전제곱수 합과 min값 교체!
		for (int i = (int) Math.sqrt(n); Math.pow(i, 2) >= m; i--) { // 큰 수부터 작은수쪽으로 i값 설정
			sum += Math.pow(i, 2);
			min = Integer.min(min, (int)Math.pow(i, 2)); // min교체
		}

		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}

	}

}
