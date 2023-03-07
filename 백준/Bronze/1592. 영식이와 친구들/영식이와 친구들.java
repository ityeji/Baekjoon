
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static int n;

	static int m;

	static int l;

	// 카운팅 배열
	static int[] arr;

	// 던진 횟수 카운트
	static int count = 0;

	public static void input() {
		n = sc.nextInt();

		arr = new int[n];

		m = sc.nextInt();

		l = sc.nextInt();

		solved(0); // 0번 인덱스를 1번 자리라고 생각하자.
	}

	public static void solved(int i) {

		arr[i]++; // 카운트 +1

		if (arr[i] < m) {
			count++; // 총 던진 횟수 ++
			// 어떤 사람이든 m번 받을 때까지 던져야 하므로
			// m번이 되지않았다면 -> 던져야한다 -> count++

			if (arr[i] % 2 == 0) { // 짝수면
				if (i - l < 0) { // 반시계방향인데, 0 인덱스를 넘어가버리면?
					solved(n + (i - l)); // 원형 큐처럼 인덱스가 돌아가게끔 설정
				} else {
					solved(i - l);
				}
			} else {
				if (i + l >= n) {
					solved((i + l) - n);
				} else {
					solved(i + l);
				}
			}
		} else {
			return;
		}

	}

	public static void main(String[] args) {
		input();
		System.out.println(count);
	}

}
