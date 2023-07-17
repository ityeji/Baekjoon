import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	// 중복을 피해야하니, set을 사용하자!

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Set<String> set = new HashSet<>();

		// String의 substring을 쓰자!
		String string = sc.next();

		for (int i = 0; i < string.length(); i++) {
			for (int j = i + 1; j <= string.length(); j++) {
				set.add(string.substring(i, j));
			}
		}

		System.out.println(set.size());

	}

}