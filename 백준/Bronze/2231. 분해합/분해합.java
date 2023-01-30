
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// for문 돌려서 몇의 자리수인지 구하고 (총 자리수는 10의 몇제곱인지 구한 값 +1)
		// 각 자리수의 최대값인 9를 그 자리수만큼 반복해서 더한 값을
		// 입력 받은 값에 빼주고
		// 그 숫자부터 시작해서 분해합이 n이 나오는 생성자를 구한다.

		// 먼저, for문 돌려서 cnt 세자 (cnt = 10의 몇제곱인지)
		int cnt = 0;

		for (int i = 1; Math.pow(10, i) < n; i++) {
			cnt++;
		}

		cnt++; // 총자리수를 구하기 위해 +1해주기

		// 새로운 변수에 입력값 복사한 후, 반복문을 통해 9씩 빼주기
		int num = n;

		for (int i = 0; i < cnt; i++) {
			num -= 9;
		}

		// num부터 시작해서 분해합이 n나오는 생성자 구하기

		// 합 저장할 변수
		int hap = 0;

		// 결과 저장할 변수
		int result = 0;

		for (int i = num; i < n; i++) {
			hap = i; // 어차피 num은 더해줘야하니까 초기화해버리기. num은 하나씩 늘어나야하므로, i로 초기화하기

			// for문 돌려서 몫 result에 더해주기
			for (int j = cnt; j > 0; j--) {
				int na = (int) (i % Math.pow(10, j)); // 나머지를 활용해서 몫을 구할 것
				// 몫을 구할 때 계속 나눠지는 수가 변해야하기 때문에(10씩 나누어져야 하기 때문에)

				int mok = (int) (na / Math.pow(10, j - 1));

				hap += mok;

			}

			if (hap == n) {
				result = i;
				break;
			}
		}

		if (hap != n) {
			result = 0;
		}

		System.out.println(result);

	}

}
