import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();

		// Arrays.sort 쓰면 시간초과나니까
		// ArrayList 써서 Collections.sort로 쓰자
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}

		Collections.sort(arr);

		for (int num : arr) {
			sb.append(num).append("\n");
		}

		System.out.println(sb);

	}

}