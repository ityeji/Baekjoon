import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] arr = new char[8][8];

		for (int row = 0; row < 8; row++) {
			String s = sc.next();
			for (int col = 0; col < 8; col++) {
				arr[row][col] = s.charAt(col);
			}
		}

		boolean color = true; // 흰색이다

		int result = 0;

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (color && arr[row][col] == 'F') {
					result++;
				}
				if (color) {
					color = false;
				} else {
					color = true;
				}
			}

			if (color) {
				color = false;
			} else {
				color = true;
			}
		}

		System.out.println(result);

	}

}