import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int cnt = 1; // end == n일 때도 카운트 해줘야하므로
		int sum = 1; // start와 end가 동일할 때, sum == star
		int start = 1;
		int end = 1;

		while (end != n) {
			if (sum == n) {
				cnt++;
				end++;
				sum += end;
			} else if (sum > n) {
				sum -= start;
				start++;
			} else {
				end++;
				sum += end;
			}
		}

		System.out.println(cnt);

	}

}