import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 단어 길이가 같으면?
				if (o1.length() == o2.length()) {
					// 단어 사전순으로 정렬 (compareTo)
					return o1.compareTo(o2);
				} else {
					// 단어 길이가 다르면?
					return o1.length() - o2.length();
					// 만약, 반환값이 양수면 -> 서로 위치 바뀜
				}
			}
		});

		// 중복 값 없애야함.
		System.out.println(arr[0]); // 어쨌든 만약 인덱스1이 0과 같은 원소라면?
		// 인덱스 1은 출력안될거니까~
		// 일단 먼저 인덱스 0은 출력해놓고 시작!

		// 인덱스 1부터 돌면서 만약, 그 전 원소와 같지않으면?
		// 출력!
		for (int i = 1; i < n; i++) {
			if (!arr[i].equals(arr[i - 1])) {
				System.out.println(arr[i]);
			}
		}

	}

}