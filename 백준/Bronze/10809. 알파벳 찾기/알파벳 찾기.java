
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		// String 나누기
		char[] arr = new char[s.length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.charAt(i);
		}

		// 알파벳 위치 저장 배열
		int[] alpha = new int[26];
		int cnt = 0; // alpha 배열 요소

		for (int i = 97; i <= 122; i++) {

			for (int j = 0; j < arr.length; j++) {
				if ((char) i == arr[j]) {
					alpha[cnt] = j;
					break;
				} else {
					alpha[cnt] = -1;
				}

			}
			cnt++;
		}

		// 배열 출력
		for (int i = 0; i < alpha.length; i++) {
			System.out.print(alpha[i] + " ");
		}

	}

}
