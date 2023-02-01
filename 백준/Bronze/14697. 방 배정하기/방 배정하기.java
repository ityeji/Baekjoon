
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n1 = sc.nextInt();

		int n2 = sc.nextInt();

		int n3 = sc.nextInt();

		int people = sc.nextInt();

		// 삼중 for문을 이용해서
		// 가장 큰 수부터 증가하는 수를 곱해서
		// if문으로 인원수와 일치하는지를 판별해서
		// 1 혹은 0 출력하기

		// 정답 저장
		int result = 0;

		x: for (int i = 1; (n1 * i) <= people; i++) {
			for (int j = 1; (n2 * j) <= people; j++) {
				for (int z = 1; (n3 * z) <= people; z++) {
					if ((n3 * z) + (n2 * j) != people) {
						if (((n3 * z) + (n2 * j) + (n1 * z)) == people) {
							result = 1;
							break x; // 어차피 완전하게 나눠졌으므로 for문 빠져나오기

						} else {
							result = 0;
						}
					} else {
						result = 1;
						break x;// 어차피 완전하게 나눠졌으므로 for문 빠져나오기
					}
				}
			}
		}

		System.out.println(result);

	}

}
