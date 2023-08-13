import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[9][9];

		int max = 0;

		int i = 0;
		int j = 0;

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				int tmp = sc.nextInt();
				arr[row][col] = tmp;
				if (tmp > max) {
					max = tmp;
					i = row;
					j = col;
				}
			}
		}

		System.out.println(max);
		System.out.print((i + 1) + " " + (j + 1));

	}

}