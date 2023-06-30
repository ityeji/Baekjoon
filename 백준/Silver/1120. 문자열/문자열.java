import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();

		int j = 0;

		int min = Integer.MAX_VALUE;

		while (j <= b.length - a.length) {
			int count = 0;

			// 만약 a가 b보다 길이가 짧다면?
			// a의 길이가 b의 길이와 같아질 때까지
			// 1. a의 앞에 아무 알파벳 추가
			// 2. b의 앞에 아무 알파벳 추가
			// 그러나, 차이가 최소여야 하므로, b와 같은 알파벳을 넣으면 된다.

			// 위의 과정 실행 전, 주어진 a가 b의 어디에 있어야 차이가 최소가 되는지 찾고,
			// 해당 위치에서 앞/뒤로 b와 같은 알파벳을 붙인다고 생각하면 됨
			// 굳이 실제로 붙일 필요는 없어
			// 어디에 있어야 차이가 최소가 되는지만 찾으면 됨!

			int idx = 0;

			for (int i = 0 + j; i < b.length; i++) {

				if (a[idx] != b[i]) {
					count++;
				}

				idx++;

				if (idx == a.length) {
					break;
				}
			}

			min = Math.min(min, count);

			j++;
		}

		System.out.println(min);
	}

}