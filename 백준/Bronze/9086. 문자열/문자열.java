import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			sb.append(s.charAt(0)).append(s.charAt(s.length() - 1)).append("\n");
		}

		System.out.println(sb);

	}

}