
import java.util.Scanner;

public class Main {

	static int sum;

	public static int recursion(String s, int l, int r) {
		if (l >= r) {
			return 1; // String의 앞 인덱스가 뒤부터 오는 인덱스를 추월했다는 것은?
			// 계속 앞 뒤가 같았다!
			// 그러면 1 리턴
		} else if (s.charAt(l) != s.charAt(r)) {
			return 0; // 같지 않으면 0리턴
		} else {
			sum++;
			return recursion(s, l + 1, r - 1); // 재귀 함수 써서 계속 돌게끔
		}
	}

	public static int input(String s) {
		sum++;
		return recursion(s, 0, s.length() - 1);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트케이스 입력
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			sum = 0;
			String s = sc.next();
			System.out.println(input(s) + " " + sum);

		}

	}

}
