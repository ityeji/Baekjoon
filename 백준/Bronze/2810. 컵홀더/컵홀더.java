
import java.util.Scanner;

public class Main {

	public static int solve(char[] arr) { // char 배열을 인자로 받음
		// S만 있다고 가정하면
		// 왼쪽에는 무조건 컵홀더가 있고
		// 오른쪽에는 가장자리에만 하나 있으므로
		// 총 컵홀더의 개수는 S+1개

		// L(커플석)의 경우는 양쪽에 하나 기준으로
		// 2인 당 컵홀더 하나

		// 컵홀더 개수 저장할 변수 생성
		double sum = 0; // 하나의 L좌석 당 0.5개의 컵홀더를 사용할 수 있으니 double로 선언

		int sChair = 0; // s가 나오면 전체 컵홀더의 개수는 전체 S의 개수 +1 이므로
		// 따로 S석 숫자 세주기

		// for문 돌면서 S나오면 개수 세기
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'S') {
				sChair++; // S는 무조건 컵홀더 하나 쓸 수 있음.

			} else {
				sum += 0.5; // L은 2인 당 컵홀더 하나 -> 1인당 컵홀더 0.5
			}
		}

		sum += (sChair + 1); // 전체 S의 개수에 1을 더하고 원래 L 컵홀더를 더해준 sum을 더한다.

		// 그런데, 컵홀더 개수 세는 것이 아니야...
		// 컵홀더를 쓸 수 있는 최대의 사람을 구하는 거지,,

		// 그럼!!! sum이 사람보다 더 많으면
		// 사람을 리턴하자!
		if (arr.length < sum) {
			return arr.length;
		}
		return (int) sum; // return값은 int이므로, double을 int로 형변환해줌
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char[] arr = new char[n];

		sc.nextLine();

		String chair = sc.nextLine();

		// 배열 저장
		for (int i = 0; i < chair.length(); i++) {
			arr[i] = chair.charAt(i);
		}

		System.out.println(solve(arr));

	}

}
