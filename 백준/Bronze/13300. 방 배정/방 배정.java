
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static int n; // 수학여행에 참가하는 학생 수

	static int k; // 한 방에 배정할 수 있는 최대 인원 수

	static int[][] room = new int[6][2];

	static int result; // 방의 최소 개수

	public static void input() {
		n = sc.nextInt();

		k = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int sex = sc.nextInt();
			int grade = sc.nextInt();

			room[grade - 1][sex]++;

		}

		solved();
	}

	public static void solved() {
		result = 0;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				if (room[i][j] != 0) {
					if (room[i][j] > k) {
						result = result + ((room[i][j] / k) + 1);
					} else {
						result++;
					}

				}
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) {

		input();

	}

}
