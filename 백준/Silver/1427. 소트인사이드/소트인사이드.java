import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		int[] arr = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i) - '0';

		}

		Arrays.sort(arr);

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}

	}

}