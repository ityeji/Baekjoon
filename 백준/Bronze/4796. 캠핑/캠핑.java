
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 먼저, 입력이 계속 될 때 String으로 한 줄씩 입력 받고,
		// String을 공백기준으로 쪼개서 String 배열에 넣기
		// 그리고, 배열에 인덱스 주고, Integer.parse써서 int배열에 넣어주기

		// 강산이는 휴가 내내 연속하는 입력값

		Scanner sc = new Scanner(System.in);
		int[] days = new int[3];

		List<Integer> result = new ArrayList<>(); // 결과값 저장해서 한 번에 출력하기
		// 얼마나 받을지 모르니까 list사용

		while (true) {

			for (int j = 0; j < days.length; j++) {
				days[j] = sc.nextInt();
			}

			if (days[0] == 0) { // 0일때 반복문 빠져나오기
				break;
			}

			// 일단 먼저 8일로 나누고 딱 맞아 떨어지는 구간은 최대한 5일을 사용한다고 치자
			int day1 = (days[2] / days[1]) * days[0];

			// 그리고 나머지 일수를 더해주려고 했는데...
			// 만약 연속 8일은 아니지만, 5일이 넘어가면??
			// 예외처리 해줘야함!
			int day2 = (days[2] % days[1]);
			if ((days[2] % days[1]) > days[0]) {
				day2 = days[0];
			}

			result.add(day1 + day2);

		}

		// 출력
		for (int i = 0; i < result.size(); i++) {
			System.out.println("Case " + (i + 1) + ": " + result.get(i));
		}

	}

}
