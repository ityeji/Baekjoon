
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static StringBuilder sb = new StringBuilder();

	// 첫 번째 직사각형 왼쪽 아래 좌표와 오른쪽 위 좌표 배열에 담기
	// 두 번째 직사각형도 마찬가지로 저장
	// 왼쪽은 왼쪽끼리, 오른쪽은 오른쪽끼리
	// 위쪽에 위치할 직사각형의 x좌표 구하기 위해 최대값 구해주고
	// 위쪽에 위치할 직사각형의 y좌표 구하기 위해 최대값 구하기
	// 반대로, 아래쪽에 위치할 직사각형의 p좌표 구하기 위해 최소값 구해주고
	// 아래쪽에 위치할 직사각형의 q좌표 구하기 위해 최소값 구해주기

	// 그래서 도출한 x와 p의 차를 구해 변수에 저장 xDiff
	// 도출한 y와 q의 차를 구해 변수에 저장 yDiff

	// xDiff > 0 || yDiff > 0 -> 아예 떨어져 있음 (d)
	// xDiff == 0 && yDiff == 0 -> 한 점이 붙어있음 (c)
	// (xDiff == 0 && yDiff != 0)||(xDiff != 0 && yDiff == 0) -> 선분이 붙어있음(b)
	// 아니면 -> 공통 부분이 없음(d)

	static int[] x = new int[2];

	static int[] y = new int[2];

	static int[] p = new int[2];

	static int[] q = new int[2];

	// 위의 직사각형 저장할 변수
	static int maxX;

	static int maxY;

	// 아래의 직사각형 저장할 변수

	static int minP;

	static int minQ;

	// 차를 저장할 변수

	static int xDiff;

	static int yDiff;

	static char result; // 결과값 저장

	public static void input() {

		for (int i = 0; i < 2; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			p[i] = sc.nextInt();
			q[i] = sc.nextInt();
		}
	}

	public static void solved() {

		input();

		maxX = Integer.max(x[0], x[1]);
		maxY = Integer.max(y[0], y[1]);
		minP = Integer.min(p[0], p[1]);
		minQ = Integer.min(q[0], q[1]);

		xDiff = maxX - minP;
		yDiff = maxY - minQ;

		if (xDiff > 0 || yDiff > 0) {
			result = 'd';
		} else if (xDiff == 0 && yDiff == 0) {
			result = 'c';
		} else if ((xDiff == 0 && yDiff != 0) || (xDiff != 0 && yDiff == 0)) {
			result = 'b';
		} else {
			result = 'a';
		}

		sb.append(result + "\n");
	}

	public static void main(String[] args) {

		for (int i = 0; i < 4; i++) {
			solved();
		}
		System.out.println(sb);

	}

}
