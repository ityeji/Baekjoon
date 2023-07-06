import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int len = Math.min(n, m);

		int[][] arr = new int[n][m];

		for (int row = 0; row < n; row++) {
			String s = sc.next();
			for (int col = 0; col < m; col++) {
				arr[row][col] = s.charAt(col) - '0';
			}
		}

		// len은 정사각형의 한변의 길이이고
		// 가장 넓게 정사각형 잡고 -> 점점 좁혀가기 (len--)
		// 위에서 len을 정의할 때는 최대 변 길이가 n과 m중 짧은 것이므로 숫자가 더 작은 것을 len으로 정의

		while (len > 1) { // 나 자신만 정사각형일 수 있으므로

			for (int row = 0; row <= n - len; row++) {
				for (int col = 0; col <= m - len; col++) {
					int num = arr[row][col];

					// 꼭짓점이 같으면
					if (num == arr[row][col + len - 1] && num == arr[row + len - 1][col]
							&& num == arr[row + len - 1][col + len - 1]) {
						System.out.println(len * len);
						return; // 이거 안해주면 출력이 여러개 나오는 경우가 있어!
					}
				}
			}

			len--;
		}

		// 여기로 빠져나왔다는 것은?
		// 꼭짓점이 같은 정사각형이 없고,
		// len == 1
		// 나 자신!
		System.out.println(len * len);

	}

}