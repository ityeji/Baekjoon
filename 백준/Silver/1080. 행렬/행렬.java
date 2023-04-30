import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static int[][] arr1;
	static int[][] arr2;
	static int count;

	static Scanner sc = new Scanner(System.in);

	public static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		arr1 = new int[n][m];
		arr2 = new int[n][m];
		count = 0;

		String tmpString = "";

		for (int row = 0; row < n; row++) {
			tmpString = sc.next();
			for (int col = 0; col < m; col++) {
				arr1[row][col] = tmpString.charAt(col) - '0';
			}
		}
		for (int row = 0; row < n; row++) {
			tmpString = sc.next();
			for (int col = 0; col < m; col++) {
				arr2[row][col] = tmpString.charAt(col) - '0';
			}
		}

	}

	public static void solved() {
		// 시작 인덱스 + 3 <= 끝인덱스여야함
		// 한칸한칸 비교하면서, 서로 다르면 row+2 col+2 범위의 것들 다 바꿔주자(바꾸면서 count 필수)
		// 그리고 최종에 확인하면서 다르면 -1출력

		// 먼저, 만약, 배열 차제가 3보다 작다? -> -1 출력
		if (n < 3 || m < 3) {
			// 서로 같은지 확인
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (arr1[row][col] != arr2[row][col]) {
					count = -1;
					return;
				}
			}
		}
		}

		for (int row = 0; row < n - 2; row++) {
			for (int col = 0; col < m - 2; col++) {
				if (arr1[row][col] != arr2[row][col]) {
					count++;
					// 서로 다르면?
					// arr1의 원소가 0 -> 1 || 1 -> 0
					for (int tmprow = row; tmprow < row + 3; tmprow++) {
						for (int tmpcol = col; tmpcol < col + 3; tmpcol++) {
							if (arr1[tmprow][tmpcol] == 0) {
								arr1[tmprow][tmpcol] = 1;
							} else {
								arr1[tmprow][tmpcol] = 0;
							}
						}
					}
				}
			}
		}

		// 서로 같은지 확인
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (arr1[row][col] != arr2[row][col]) {
					count = -1;
					return;
				}
			}
		}

	}

	public static void main(String[] args) {
		input();
		solved();
		System.out.println(count);
	}

}