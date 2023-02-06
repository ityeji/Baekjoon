
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// String으로 받아서
		// charAt(i)가 5면 6에 자릿수만큼 제곱해서 더해주고
		// 나머지는 해당 자리 숫자에 자릿수만큼 제곱해서 더해줌
		// 첫입력이 5일 때, 6일 때
		// 두번째입력이 5일 때, 6일 때 구해서
		// 더해주면된다!

		Scanner sc = new Scanner(System.in);

		String input1 = sc.next();
		String input2 = sc.next();

		// 5일 때 최댓값
		int intInput1 = 0;

		// 첫번째 입력
		for (int i = 0; i < input1.length(); i++) {
			if (input1.charAt(i) == '5') {
				intInput1 += (6 * Math.pow(10, input1.length() - 1 - i));
			} else {
				intInput1 += ((input1.charAt(i) - '0') * Math.pow(10, input1.length() - 1 - i));
			}
		}

		int intInput2 = 0;
		// 2번째 입력
		for (int i = 0; i < input2.length(); i++) {
			if (input2.charAt(i) == '5') {
				intInput2 += (6 * Math.pow(10, input2.length() - 1 - i));
			} else {
				intInput2 += ((input2.charAt(i) - '0') * Math.pow(10, input2.length() - 1 - i));
			}
		}

		int max = intInput1 + intInput2; // 5를 6으로 바꿔주면 합이 최대

		intInput1 = 0;
		intInput2 = 0;
		// 다시 초기화 하고 최소값 구해주기

		// 첫번째 입력
		for (int i = 0; i < input1.length(); i++) {
			if (input1.charAt(i) == '6') {
				intInput1 += (5 * Math.pow(10, input1.length() - 1 - i));
			} else {
				intInput1 += ((input1.charAt(i) - '0') * Math.pow(10, input1.length() - 1 - i));
			}
		}

		// 2번째 입력
		for (int i = 0; i < input2.length(); i++) {
			if (input2.charAt(i) == '6') {
				intInput2 += (5 * Math.pow(10, input2.length() - 1 - i));
			} else {
				intInput2 += ((input2.charAt(i) - '0') * Math.pow(10, input2.length() - 1 - i));
			}
		}

		int min = intInput1 + intInput2; // 6을 5로 바꿔주면 합이 최소

		System.out.println(min + " " + max);
	}

}
