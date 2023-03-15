
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static int num;

	static int[][] map;

	static final int AREA = 10;

	public static void input() {
		map = new int[100][100];

		num = sc.nextInt();

		for (int n = 1; n <= num; n++) {
			int y = sc.nextInt();
			int x = sc.nextInt();

			for (int row = x; row < x + AREA; row++) {
				for (int col = y; col < y + AREA; col++) {
					map[row][col] = n;
				}
			}
		}

		int count = 0;

		for (int row = 0; row < 100; row++) {
			for (int col = 0; col < 100; col++) {
				if (map[row][col] != 0) {
					count++;
				}
			}
		}

		System.out.println(count);
	}

	public static void main(String[] args) {
		input();

	}

}
