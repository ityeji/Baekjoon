import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char[][] arr = new char[n][n];

		for (int row = 0; row < n; row++) {
			String s = sc.next();
			for (int col = 0; col < n; col++) {
				arr[row][col] = s.charAt(col);
			}
		}

		int result = 0;
		int count;

		// .이 연속해서 두개 이상이면 result++해주기
		for (int row = 0; row < n; row++) {
			count = 0;
			for (int col = 0; col < n; col++) {
				if (arr[row][col] == '.') {
					count++;
				} else {
					count = 0;
				}
				if (count == 2) {
					result++;
				}
			}
		}

		System.out.print(result + " ");

		result = 0;

		for (int row = 0; row < n; row++) {
			count = 0;
			for (int col = 0; col < n; col++) {
				if (arr[col][row] == '.') {
					count++;
				} else {
					count = 0;
				}
				if (count == 2) {
					result++;
				}
			}

		}

		System.out.print(result);

	}

}