import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		int k = sc.nextInt();

		long[] arr = new long[k]; // 출력 범위 고려해서 int -> long

		int mok = s / k;

		int na = s % k;

		for (int i = 0; i < k; i++) {
			arr[i] = mok;
		}
		for (int i = 0; i < na; i++) {
			arr[i] += 1;
		}

		long mul = 1; // 출력 범위 고려해서 int -> long

		for (int i = 0; i < k; i++) {
			mul *= arr[i];
		}

		System.out.println(mul);

	}

}