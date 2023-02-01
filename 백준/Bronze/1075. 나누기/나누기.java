
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int f = sc.nextInt();

		// 이중 for문을 돌리면서 숫자 바꿔주고 k로 나누어지면 result1를 리턴
		// result1과 result2를 비교하여
		// 작은 수를 출력한다.

		int result = 0; // 더했을 때 결과 값 저장

		x: // label 붙여서 한 번에 빠져나오자!
		for (int i = 0; i <= 9; i++) { // 0~9까지 돌기
			for (int j = 0; j <= 9; j++) { // 0~9까지 돌기
				if ((((n / 100) * 100) + ((i * 10) + j)) % f == 0) {
					// n/100은 몫만 구해지고, 몫에 100곱하면
					// 100의자리까지만 구해진다
					// 어차피 십의자리수까지만 바꿀 거니까
					// 거기에 i에 10곱하면 i는 십의자리수가 됨
					result = (i * 10) + j;
					break x;
				}
			}

		}

		if (result / 10 == 0) {
			// result를 10으로 나눈 몫이 0이라면
			// 일의 자리라는 이야기!
			System.out.println("0" + result);
		} else {
			System.out.println(result);
		}

	}

}
