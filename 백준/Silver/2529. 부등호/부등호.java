import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	// 조합처럼 생각해서 풀어보장
	// 재귀 사용해야겠네!

	static Scanner sc = new Scanner(System.in);

	static boolean[] check = new boolean[10]; // 0-9까지 사용여부 체크할 배열

	static int k; // 부등호 문자 개수

	static char[] sign; // k개의 부등호가 나오는데, k는 9까지 나올 수 있음

	static ArrayList<String> result; // 숫자 조합이 몇 개가 나올지 모르니 ArrayList로 받기
	// Integer로 하면, 숫자를 다 더해버리니까
	// String으로 해서 숫자 본연 모습을 가지고 있도록 해야함.

	public static void input() {

		k = sc.nextInt();

		sign = new char[k];

		result = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			sign[i] = sc.next().charAt(0);
		}
	}

	// 부등호와 앞뒤 숫자가 잘 매칭되는지를 판단하는 메소드
	public static boolean check(int a, int b, char c) {

		if (c == '>') {
			if (a < b) {
				return false;
			}
		} else if (a > b) {
			return false;
		}

		return true;
	}

	// 결과값을 ArrayList에 넣어주는 메소드
	public static void makeResult(int idx, String num) {
		// idx는 현재 num의 인덱스 자리

		// 조합처럼 쓸거라 재귀 돌릴 것이니...
		// 기저 조건부터!
		if (idx == k + 1) {
			// 만약 부등호가 k개이면, 숫자는 총 k+1개
			// 숫자 본연의 모습을 살리기 위해 String으로 넣을건데...
			// 숫자 하나하나씩 넣을 거니까 charAt
			// 인덱스로 따지면 마지막 숫자의 인덱스는 k
			result.add(num);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (check[i]) { // 똑같은 숫자 안돼!
				continue;
			}

			if (idx == 0 || check(num.charAt(idx - 1) - '0', i, sign[idx - 1])) {
				// idx를 0부터 시작해야하는데(num의 현재 위치이니까)
				// charAt(-1)라면 에러가 나니까
				// 조건문에 idx==0을 적어주어야한다.(그러면 뒤까지 확인하지 않고 바로 true로 반환하여 조건문 안으로 들어오니까)

				check[i] = true; // 박문철2

				// 또 한 번 돌아봐라
				makeResult(idx + 1, num + Integer.toString(i));
				check[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		input();
		makeResult(0, ""); // String을 파라미터로 넣어야하고, 이 num을 결과값으로 저장해주니까 ""를 파라미터로 건네주어야함.

		// 정렬해서 최대값과 최소값을 출력하자
		Collections.sort(result);

		// 최대값
		System.out.println(result.get(result.size() - 1));

		// 최소값
		System.out.println(result.get(0));
	}

}