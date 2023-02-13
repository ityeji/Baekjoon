
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 1. 스위치 개수 입력 받기
		// 2. 스위치 개수만큼 배열 만들기
		// 3. 배열 저장하기
		// 4. 학생 수 입력 받고 while문 돌리기 (테스트케이스 개념)
		// 5. 학생 성별에 따라 case로 나눠서 스위치 바꿔주기 (남자: 1, 여자: 2)

		Scanner sc = new Scanner(System.in);

		// 1. 스위치 개수 입력 받기
		int num = sc.nextInt();

		// 2. 스위치 개수만큼 배열 만들기
		int[] sArr = new int[num];

		// 3. 배열 저장하기
		for (int i = 0; i < sArr.length; i++) {
			sArr[i] = sc.nextInt();
		}

		// 4. 학생 수 입력 받고 while문 돌리기
		int students = sc.nextInt();

		while (students > 0) {

			// 5. 학생 성별에 따라 case로 나눠서 스위치 바꿔주기(남자: 1, 여자: 2)
			// 그러면 먼저, 학생 성별부터 입력 받아야겠지??

			int sex = sc.nextInt();
			// 수를 입력받는다
			int n = sc.nextInt();

			switch (sex) {
			case 1: // 남자일 경우
				for (int i = 0; i < sArr.length; i++) {
					if ((i + 1) % n == 0) { // 입력받은 수의 배수이면 스위치의 상태를 바꾼다.
						if (sArr[i] == 0) { // 스위치가 0이면
							sArr[i] = 1; // 1로 바꾸기
						} else { // 어차피 스위치는 0 아니면 1
							sArr[i] = 0; // 1이면 0으로 바꾸기
						}
					}
				}

				break;
			case 2: // 여자일 경우
				// for문으로 n에서 i를 조작하여 인덱스 값을 주고 요소에 접근

				// 자기 자신은 무조건 바뀌어야함.
				// 인덱스는 0부터 시작이므로 주어진 값에서 -1해준 인덱스의 요소를 바꾸어야함.
				if (sArr[n - 1] == 0) {
					sArr[n - 1] = 1;
				} else {
					sArr[n - 1] = 0;
				}

				for (int i = 0; (n - i - 2 >= 0 && n + i < sArr.length); i++) {
					// 조작한 인덱스가 0보다 작아지면 안되고, 배열의 길이보다 커져도 안된다.
					// 그래서 조건문을 이중으로 줬음.

					if (sArr[n - i - 2] == sArr[n + i]) {
						// 만약, 주어진 값이 3이면 -> 해당 인덱스는 2(3-1)
						// 그 요소의 좌우를 봐야하므로
						// 주어진 값보다 -2(좌 인덱스)
						// 주어진 값 (우 인덱스)
						if (sArr[n + i] == 0) { // 어차피, 위의 if 조건문에서 양쪽이 같을 때라고 했으므로,
							// 조건을 만족한다는 것은 -> 하나만 0인지 1인지 판별하면 되는 것
							sArr[n - i - 2] = 1; // 좌 바꿔주기
							sArr[n + i] = 1; // 우 바꿔주기
						} else {
							sArr[n - i - 2] = 0; // 좌 바꿔주기
							sArr[n + i] = 0; // 우 바꿔주기
						}
					} else {
						break;
					}
				}

				break;
			}

			students--;
		}

		// 출력을 해주자
		// 한 줄에 20개씩 출력한다.
		int idx = 0;
		for (int i = 0; idx < sArr.length; i++) {
			System.out.print(sArr[idx++] + " ");
			if (idx % 20 == 0) {
				System.out.println();
			}

		}

	}

}
