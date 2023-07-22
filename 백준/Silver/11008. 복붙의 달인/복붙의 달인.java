import java.util.Scanner;

public class Main {

	// String에서 부분문자열을 추출할 수 있는 substr 메소드를 사용하자!

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int time = sc.nextInt();

		for (int i = 0; i < time; i++) {
			int min = 0;

			String s = sc.next();
			String p = sc.next();

			s = s.replaceAll(p, ",");

			System.out.println(s.length());
		}

	}

}