import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String[][] arr = new String[n][2];

		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.next();
			arr[i][1] = sc.next();
		}

		// 먼저, 숫자로 정렬
		Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});

		// 숫자가 같으면?
		// 가입 순서대로 출력!
		for (String[] s1 : arr) {
			for (String s2 : s1) {
				System.out.print(s2 + " ");
			}
			System.out.println();
		}

	}

}