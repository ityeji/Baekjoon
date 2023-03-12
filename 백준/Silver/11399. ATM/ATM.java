
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static int n;

	static int[] atm; // 돈 인출하는 데 걸리는 시간 저장

	static int[] result; // 각 사람마다 걸리는 시간 저장하는 배열

	static int sum; // 누적합 static에 저장

	static int min; // 최소값

	public static void input() {
		n = sc.nextInt();

		atm = new int[n];

		for (int i = 0; i < n; i++) {
			atm[i] = sc.nextInt();
		}

		result = new int[n];

		solved();
	}

	public static void solved() {

		min = 0;
		sum = 0;

		// 최소값이 되려면..
		// 오름차순으로 정렬하는 게...!
		Arrays.sort(atm);

		// 누적합 구해서,
		// 그 누적합을 result 배열에 넣어주자!

		for (int i = 0; i < n; i++) {
			sum += atm[i];

			result[i] = sum;
		}

		// result배열에 있는 원소들을 다 더해준다
		sum = 0; // 다시 sum 초기화 해주고

		for (int i = 0; i < n; i++) {
			sum += result[i];
		}
		
		System.out.println(sum);
	}

	public static void main(String[] args) {

		input();

	}

}