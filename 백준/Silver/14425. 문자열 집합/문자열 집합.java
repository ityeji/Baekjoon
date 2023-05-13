import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		Set<String> s = new HashSet<>();

		for (int i = 0; i < n; i++) {
			s.add(sc.next());
		}

		int cnt = 0;

		for (int i = 0; i < m; i++) {
			if (s.contains(sc.next())) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}

}