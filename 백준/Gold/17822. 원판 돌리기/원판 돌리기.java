import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// 먼저 이차원 배열 만들고...
	// 크기는 n+1로...

	static Scanner sc = new Scanner(System.in);

	static int[][] map; // 보드 (크기는 n)

	static int[][] copyMap; // 보드 복사본

	static int n; // map 크기

	static int m; // 원판에 적힌 m개의 정수

	static int t; // t번 회전

	static int x; // x의 배수 원판 돌리기

	static int d; // d방향으로
	// 0 : 시계 -> (배열의 마지막 idx -> 첫 idx)
	// 1 : 반시계 -> (배열의 첫 idx -> 마지막 idx)

	static int k; // k칸 회전 -> k번 회전

	public static void input() {

		map = new int[n + 1][m]; // 1번 인덱스부터 사용할 거지롱

		t = sc.nextInt();

		for (int row = 1; row < n + 1; row++) {
			for (int col = 0; col < m; col++) {
				map[row][col] = sc.nextInt();
			}
		}

		for (int i = 0; i < t; i++) {

			x = sc.nextInt();

			d = sc.nextInt();

			k = sc.nextInt();

			rotation();

			// 인접하는 수 모두 찾자
			// 현재 배열 복사하자
			for (int row = 1; row < n + 1; row++) {
				for (int col = 0; col < m; col++) {
					copyMap[row][col] = map[row][col];
				}
			}

			boolean result = searchAdj();

			if (!result) {
				// 그러한 수가 없는 경우에는 원판에 적힌 수의 평균을 구하고
				// 평균보다 큰 수에서 1을 빼고, 작은 수에는 1을 더한다.
				calAvg();
			}

			for (int row = 1; row < n + 1; row++) {
				for (int col = 0; col < m; col++) {
					map[row][col] = copyMap[row][col];
				}
			}

		}
	}

	// 회전 메소드
	public static void rotation() {

		// k번 반복해야함.
		for (int i = 0; i < k; i++) {
			switch (d) {
			// d가 0이면 시계방향
			case 0:
				// 시계방향은?
				// 마지막 idx원소가 첫 idx로 이동하지
				// 어떤 원판이?
				// x의 배수 원판이! -> 그러면 x로 나눴을 때 나머지가 0이어야겠네?
				// for문 돌리면서 idx가 x의 배수인지를 확인하면서 x의 배수이면 마지막 idx 원소를 첫 idx로 이동해주자
				for (int row = 1; row < n + 1; row++) {
					// 0번 행에는 아무값도 들어가지 않으므로 1부터 시작
					if (row % x == 0) {
						// x의 배수이면?
						// 마지막 idx원소를 첫 idx원소로 이동해주자!
						// 마지막 idx원소를 저장해줄 tmp 변수
						int tmp = map[row][m - 1];

						// for문 돌리면서 앞의 원소들 뒤로 옮겨주기
						for (int col = m - 1; col > 0; col--) {
							map[row][col] = map[row][col - 1];
						}

						// 맨 앞 idx 원소에 저장해놨던 맨 뒤 idx 원소 넣어주기
						map[row][0] = tmp;
					}
				}
				break;

			// d가 1이면 반시계방향
			case 1:
				// 반시계방향은?
				// 첫 idx원소가 마지막 idx로 이동한다
				// 어떤 원판이?
				// x의 배수 원판이! -> x로 나눴을 때 나머지 0!
				// for문 돌리면서 i가 x의 배수인지를 확인하면서 x의 배수이면 마지막 idx 원소를 첫 idx로 이동해주자
				for (int row = 1; row < n + 1; row++) {
					if (row % x == 0) {
						// 첫 idx 원소를 마지막 idx 원소로 옮겨주자
						// 위의 방법과 마찬가지로!
						int tmp = map[row][0];

						for (int col = 0; col < m - 1; col++) {
							map[row][col] = map[row][col + 1];
						}

						map[row][m - 1] = tmp;
					}
				}
				break;
			}
		}
	}

	// 인접하는 수가 있어?
	// 인접하는 수가 있으면... true반환해주고 삭제처리는 이 메소드 안에서!
	// 없으면... false 반환해주고 평균보다 큰 수에서 1을 빼고, 작은 수에 1을 더해!
	// 원본이 바뀌면... 안되니까 복사본 만들자!
	// col이 m이라는 것은? 인덱스로 계산해야하니까 m-1로 바꿔주기!
	public static boolean searchAdj() {

		// 델타를 쓰라고...?

		boolean result = false;

		// (i,1)은 (i,2),(i,M)과 인접하다
		for (int row = 1; row < n + 1; row++) {
			int tmp = map[row][0];

			if (tmp > 0) {
				if (tmp == map[row][1]) {
					copyMap[row][0] = 0;
					copyMap[row][1] = 0;
					result = true;
				} else if (tmp == map[row][m - 1]) {
					copyMap[row][0] = 0;
					copyMap[row][m - 1] = 0;
					result = true;
				}
			}
		}

		// (i,M)은 (i, m-1), (i, 1)와 인접하다
		for (int row = 1; row < n + 1; row++) {
			int tmp = map[row][m - 1];

			if (tmp > 0) {
				if (tmp == map[row][m - 2]) {
					copyMap[row][m - 1] = 0;
					copyMap[row][m - 2] = 0;
					result = true;
				} else if (tmp == map[row][0]) {
					copyMap[row][m - 1] = 0;
					copyMap[row][0] = 0;
					result = true;
				}
			}
		}

		// (i ,j)는 (i, j-1), (i, j+1)와 인접하다
		for (int row = 1; row < n + 1; row++) {
			for (int col = 1; col <= m - 2; col++) {
				int tmp = map[row][col];

				if (tmp > 0) {
					if (tmp == map[row][col - 1]) {
						copyMap[row][col] = 0;
						copyMap[row][col - 1] = 0;
						result = true;
					} else if (tmp == map[row][col + 1]) {
						copyMap[row][col] = 0;
						copyMap[row][col + 1] = 0;
						result = true;
					}
				}
			}
		}

		// (1,j)는 (2,j)와 인접하다
		for (int col = 0; col < m; col++) {
			int tmp = map[1][col];

			if (tmp > 0) {
				if (tmp == map[2][col]) {
					copyMap[1][col] = 0;
					copyMap[2][col] = 0;
					result = true;
				}
			}
		}

		// (N, j)는 (N-1, j)와 인접하다
		for (int col = 0; col < m; col++) {
			int tmp = map[n][col];

			if (tmp > 0) {
				if (tmp == map[n - 1][col]) {
					copyMap[n][col] = 0;
					copyMap[n - 1][col] = 0;
					result = true;
				}
			}
		}

		// (i,j)는 (i-1, j), (i+1,j)와 인접하다
		for (int row = 2; row < n; row++) {
			for (int col = 0; col < m; col++) {
				int tmp = map[row][col];

				if (tmp > 0) {
					if (tmp == map[row - 1][col]) {
						copyMap[row][col] = 0;
						copyMap[row - 1][col] = 0;
						result = true;
					} else if (tmp == map[row + 1][col]) {
						copyMap[row][col] = 0;
						copyMap[row + 1][col] = 0;
						result = true;
					}
				}
			}
		}

		return result;
	}

	public static void calAvg() {

		int sum = 0;
		double count = 0;

		for (int row = 1; row < n + 1; row++) {
			for (int col = 0; col < m; col++) {
				if (copyMap[row][col] != 0) {
					sum += copyMap[row][col];
					count++;
				}
			}
		}

		double avg = sum / count;

		for (int row = 1; row < n + 1; row++) {
			for (int col = 0; col < m; col++) {
				int tmp = copyMap[row][col];

				if (tmp > 0) {
					if (tmp < avg) {
						copyMap[row][col]++;
					} else if (tmp > avg) {
						copyMap[row][col]--;
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		n = sc.nextInt();
		m = sc.nextInt();

		copyMap = new int[n + 1][m];

		input();

		// 회전까지 완료

		int sum = 0;

		for (int row = 1; row < n + 1; row++) {
			for (int col = 0; col < m; col++) {
				sum += copyMap[row][col];
			}
		}

		System.out.println(sum);

	}

}