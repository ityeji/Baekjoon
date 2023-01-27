
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int m = sc.nextInt();

		if (m - 45 < 0) {
			h -= 1;
			if (h < 0) {
				h = 23;
			}
			m = 60 + m - 45; //-만큼 60에서 빼주면 분이 나옴
		} else {
			m -= 45;
		}

		System.out.println(h + " " + m);

	}

}
