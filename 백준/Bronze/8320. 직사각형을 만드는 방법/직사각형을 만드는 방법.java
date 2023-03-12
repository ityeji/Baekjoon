
import java.util.Scanner;

public class Main {

	// 이중 for문을 통해 i*j가 n보다 같을때까지 반복 후 count해주기
	// 그리고 불린 체크 배열에 [i][j]와 [j][i]인덱스 true로 바꿔주기
	// 그래서 이중 for문으로 돌면서 [i][j]가 false인지 아닌지 조건으로 넣어주고
	// false이면 count해줘야함.
	// check의 크기는 넉넉잡아 n*n으로 하자!
	// 어차피 for문 조건을 i*j<=n으로 줄거라서 배열 애초에 크게 만들어도 상관 x

	static Scanner sc = new Scanner(System.in);

	static int n;

	static boolean[][] check; // 반복을 체크하는 배열

	static int count; // 만들 수 있는 직사각형 개수 카운트

	public static void input() {
		n = sc.nextInt();

		// n*n의 boolean배열 선언
		check = new boolean[n + 1][n + 1];

		solved();
	}

	public static void solved() {

		count = 0;// count변수 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; i * j <= n; j++) {
				if (check[i][j] == false) {
					count++;
					// 만들어진 직사각형이 이동, 회전하여 다른 직사각형과 만들 수 있으면 두 직사각형은 같다고 가정하므로
					// [i][j]뿐만 아니라, [j][i]도 만들었다는 true표시 해줘야함.
					check[i][j] = true;
					check[j][i] = true;
				}
			}
		}

		System.out.println(count);
	}

	public static void main(String[] args) {

		input();

	}

}
