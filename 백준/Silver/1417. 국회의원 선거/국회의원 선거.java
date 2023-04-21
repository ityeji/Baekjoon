import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int result = 0;

		while (true) {
			int max = 0;
			int idx = 0;
			for (int i = 1; i < n; i++) {
				if (arr[i] > max) {
					max = arr[i];
					idx = i;
				}
			}

			if (arr[0] <= max) {
				arr[idx]--;
				result++;
				arr[0]++;
			} else {
				break;
			}

		}

		System.out.println(result);
	}

}