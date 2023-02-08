
import java.util.Scanner;

public class Main {

	// 일단 잔돈 배열 만들어,,,
	// for문 돌릴 거니까,,,
	static int[] coins = { 500, 100, 50, 10, 5, 1 };

	static void active(int price) { // main메소드에서 불러올건데,
		// main method가 static이니까
		// 메소드에도 static 붙여주기

		int count = 0; // 동전 개수
		int n = 1000 - price; // 나머지
		// 처음에 money를 coins로 나눌 거고, n은 유동적이므로
		int sum = 0; // 잔돈 개수 더하기

		for (int i = 0; i < coins.length; i++) {
			count = n / coins[i];
			n %= coins[i];
			sum += count;
		}

		System.out.println(sum);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		active(sc.nextInt());

	}

}
