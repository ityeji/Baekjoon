import java.util.Arrays;
import java.util.Scanner;

public class Main {

	// 자릿수를 먼저 따지라굿...?
	// 알파벳 별 총 자릿수 구하기
	// 첫 번째 원소는 9*(10^queue.size()-1) ... 이런 식으로..
	// 방문 체크 처럼 따로 int배열 만들어서
	// 알파벳-65해서 인덱스 반영해서
	// 해당 알파벳이 이미 큐에서 나왔다?(poll) -> 어떤 숫자를 지정해줬는지 배열에 저장
	// for문 돌면서 int배열을 체크해주는데...
	// 0이 아니면? 해당 인덱스에서 값 가져와서 자릿수 곱해주기
	// 0이면? -> 새로운 숫자 할당해주자!

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] alphaloc = new int[26]; // 알파벳 개수만큼 크기 지정

		for (int i = 0; i < n; i++) {

			String s1 = sc.next(); // 공백 단위로 입력받기

			for (int j = 0; j < s1.length(); j++) {
				char alpha = s1.charAt(j);

				alphaloc[alpha - 65] += (int) Math.pow(10, s1.length() - j - 1);
			}
		}

		// 배열을 정렬
		Arrays.sort(alphaloc);

		// 뒤에서부터 for문 돌면서 배열 원소에 9부터 0까지 곱해주어 더해주기
		// 그것이 정답
		int num = 9;
		int sum = 0;

		for (int i = alphaloc.length - 1; i >= 0; i--) {
			sum += (num * alphaloc[i]);
			num--;
		}

		System.out.println(sum);
	}

}