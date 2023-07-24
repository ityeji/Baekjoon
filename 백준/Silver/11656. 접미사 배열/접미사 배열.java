import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		String[] arr = new String[s.length()];

		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.substring(i, s.length());
		}

		Arrays.sort(arr);

		for (String str : arr) {
			System.out.println(str);
		}

	}

}