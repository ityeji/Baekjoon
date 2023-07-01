import java.util.Scanner;

public class Main {

	// 토너먼트는 옆 상대방과 붙어야하는 게임이므로, 다 이긴다고 가정하니 무조건 만날 수밖에 없음
	// 답으로 -1이 나올 수가 없음.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int total = sc.nextInt(); // 얘는 왜 필요한거지..
		int kim = sc.nextInt(); // 김지민 몇 번?
		int im = sc.nextInt(); // 임한수 몇 번?

		// 현재 홀수라면?
		// 다음 라운드 때 n/2 + 1(n%2)
		// 현재 짝수라면?
		// 다음 라운드 때 n/2 + 0(n%2)

		int kimWin = (kim / 2) + (kim % 2);
		int imWin = (im / 2) + (im % 2);

		int round = 1; // 바로 위의 연산을 하는 순간, 1라운드가 시작되는 거니까!
		// 그렇다고 while문 안에서 위의 연산을 쓰고 round를 0으로 주면
		// 계속 입력받은 값으로만 연산되어 값이 갱신되지 않으니까
		// 이렇게 써줘야해!

		// 어차피 둘이 언젠가는 만날건데,
		// 이미 만나서 승부가 났다는 것은?
		// 둘의 숫자가 같아졌다는 것!
		// 둘의 변화된 숫자가 같지 않다 -> 아직 못만났다
		while (kimWin != imWin) {
			kimWin = (kimWin / 2) + (kimWin % 2);
			imWin = (imWin / 2) + (imWin % 2);
			round++;
		}

		System.out.println(round);

	}

}