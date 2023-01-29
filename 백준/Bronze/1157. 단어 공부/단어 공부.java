
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 알파벳 개수만큼 arr 배열 생성하고
		// 알파벳 번호인 인덱스에 ++

		String input = sc.next().toUpperCase(); // 대문자로 바꿔주기

		int[] arr = new int[26];

		// 이중 for문
		for (int i = 0; i < input.length(); i++) {

			arr[input.charAt(i) - 'A']++; // 'A'가 65이므로, 만약, A일 경우 65-65=0 -> 0번 인덱스에 들어가게 됨.
		}


		// for문 돌면서 max가 바뀌거나, max와 같은 수가 나오면? cnt++

		int max = -1; // 배열은 0부터 시작이므로 초기 max값을 -1로 잡기

		char result = '?';

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				result = (char) (i + 'A');
			} else if (arr[i] == max) {
				result = '?';
			}
		}

		System.out.println(result);

	}
}
