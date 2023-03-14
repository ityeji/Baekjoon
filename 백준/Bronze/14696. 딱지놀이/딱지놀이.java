
import java.util.Scanner;

public class Main {

	// 미리 딱지를 저장할 배열을 만들고,
	// 입력받은 딱지를 인덱스화 해서 배열++해주고
	// while 돌려서
	// 각 배열 원소 비교해서
	// A이냐 B이냐 승자 정하기
	// 만약, 원소가 같다는 것은 -> 똑같은 개수가 나왔다는 이야기니까
	// 인덱스 늘려서 다음 카드 확인해주기

	static Scanner sc = new Scanner(System.in);

	// 값 한 번에 출력해주기 위해
	static StringBuilder sb = new StringBuilder();

	static int[] cardA; // A의 딱지 저장

	static int[] cardB;

	static char result;

	public static void input() {
		int n = sc.nextInt();

		cardA = new int[5]; // 인덱스가 1~4까지 있어야 하니까
		cardB = new int[5];

		for (int i = 0; i < n; i++) {
			int card = sc.nextInt();
			cardA[card]++;
		}

		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int card = sc.nextInt();
			cardB[card]++;
		}

		solved();
	}

	public static void solved() {
		int i = 4;
		while (i >= 1) {

			if (cardA[i] == cardB[i]) {
				result = 'D';
				i--;
			} else if (cardA[i] > cardB[i]) {
				result = 'A';
				break;
			} else {
				result = 'B';
				break;
			}
		}

		sb.append(result + "\n");
	}

	public static void main(String[] args) {
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {

			input();
		}

		System.out.println(sb.toString());

	}

}
