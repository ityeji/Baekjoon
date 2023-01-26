
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int cnt = 1;

		while (n > 0) {
			// 공백찍기
			for (int i = 0; i < n - 1; i++) {
				System.out.print(" ");
			}

			// *찍기
			for (int i = 0; i < cnt; i++) {
				System.out.print("*");
			}
			cnt++;
			n--;

			System.out.println();
		}

	}

}
