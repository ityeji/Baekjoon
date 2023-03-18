
import java.util.Scanner;

public class Main {
	// 먼저 긴 가로와 세로 길이를 구해서 저장
	// 인덱스 활용해서 (idx+1)%6 // (idx+5)%6
	// 짧은 세로일 때와 짧은 가로일 때 구해서
	// 서로 곱해서 큰 직사각형 넓이에서 빼주기
	// 거기에 참외 수 곱하기
	// 짧은 세로는? 양옆인덱스의 요소 더한 것이 긴 가로와 같으면? -> 해당 인덱스 요소는 짧은 세로다!
	// 짧은 가로는? 위와 같이 긴 세로와 같으면? -> 해당 인덱스 요소는 짧은 가로다!!

	static int m; // 참외 개수

	static Scanner sc = new Scanner(System.in);

	static int result; // 결과 값 저장

	static int[] length = new int[6]; // 길이 저장

	static int longwidth; // 긴가로

	static int longheight; // 긴세로

	static int shortwidth; // 짧은 가로

	static int shortheight; // 짧은 세로

	public static void input() {

		longwidth = 0;

		longheight = 0;

		m = sc.nextInt();

		for (int i = 0; i < 6; i++) {
			int direc = sc.nextInt();

			int len = sc.nextInt();

			length[i] = len;

			switch (direc) {
			case 1:
			case 2:
				longwidth = Integer.max(longwidth, len);
				break;
			case 3:
			case 4:
				longheight = Integer.max(longheight, len);
				break;
			}
		}

		solved();
	}

	public static void solved() {

		for (int i = 0; i < 6; i++) {
			// 안쪽으로 들어간 변의 양 옆
			int insideLeft = length[(i + 5) % 6];
			int insideRight = length[(i + 1) % 6];

			// 양 옆의 가로가 긴 가로와 같다면?
			// 해당 인덱스의 원소는 안쪽 세로의 길이!
			if ((insideLeft + insideRight) == longwidth) {
				shortheight = length[i];
			}

			// 양 옆의 세로가 긴 세로가 같다면?
			// 해당 인덱스의 원소는 안쪽 가로의 길이!
			if ((insideLeft + insideRight) == longheight) {
				shortwidth = length[i];
			}
		}

		result = ((longwidth * longheight) - (shortwidth * shortheight)) * m;

		System.out.println(result);
	}

	public static void main(String[] args) {

		input();

	}

}
