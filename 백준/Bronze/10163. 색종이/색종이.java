
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static int num;

	public static void input() {

		num = sc.nextInt();
		
		int[][] map = new int[1001][1001];

		for (int n = 1; n <= num; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();

			// map에다 현재 몇 번째 종이인지를 써주기
			// 범위는 입력된 좌표에서 입력된 범위만큼
			// 좌표를 한 칸씩 이동하면 된다.
			// 좌표 움직이면서 몇 번째 종이인지 적어주기

			// 이것을 num번 반복하면?
			// 만약, 1이 있었던 곳이라면 거기가 2로 바뀔 것이고...
			// 겹칠 수록 나중 num이 채워진다.
			for (int col = y; col < y + height; col++) {
				for (int row = x; row < x + width; row++) {
					map[row][col] = n;
				}
			}
		}

		for (int n = 1; n <= num; n++) {
			int count = 0;

			// map 돌아가면서 원소에 n이 적혀있는 것들 count
			for (int row = 0; row < 1001; row++) {
				for (int col = 0; col < 1001; col++) {
					if (map[row][col] == n) {
						count++;
					}
				}
			}

			System.out.println(count);
		}

	}

	public static void main(String[] args) {

		input();

	}

}
