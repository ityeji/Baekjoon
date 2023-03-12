
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static int n;

	static int k;

	static ArrayList<Integer> people = new ArrayList<>();

	static int[] result; // 제거된 사람들 저장할 배열

	public static void input() {
		n = sc.nextInt();
		k = sc.nextInt();

		// ArrayList에 사람저장하기
		for (int i = 1; i <= n; i++) {
			people.add(i);
		}

		solved();
	}

	public static void solved() {
		int idx = 0; // result배열 인덱스

		int peopleidx = 0; // k번째 사람이 리스트에서 사라지면, 그 자리에 다른 사람이 채워지게 되고,
		// 그 사람부터 다시 k만큼 count해줘야하니까,
		// 사람이 제거된 인덱스를 저장해줘야함.

		result = new int[n];

		int count = k;
		int i = peopleidx;
		while (people.size() != 0) {

			if (people.size() == 1) {
				result[idx] = people.remove(i);
				break;
			}

			if (count == 1) {
				result[idx++] = people.remove(i);
				peopleidx = i;
				count = k;
			} else {
				count--;
				i++;
			}

			if (i == people.size()) {
				// people을 가리키는 인덱스 i가 people.size()-1일 때 0이면 안되는 이유?
				// i가 people.size()-1일 때 바로 0으로 바꿔주면?
				// 원소를 끝까지 볼 수 없게 된다
				// 위에서 i를 조정해주고 마지막 인덱스인채로 반복문 다시 시작하려 했더니?
				// 인덱스 (i)를 0으로 바꿔버렸기 때문에
				// 그러면? 언제 i가 0이 되어야해?
				// 인덱스(i)가 어레이리스트의 범위를 넘어가면!!
				// 그러면 i가 people.size()이면 -> 마지막 인덱스를 넘어가면
				// 그 때 인덱스를 다시 0으로 조정해주자!
				i = 0;
			}
		}

		System.out.print("<");
		for (int j = 0; j < n; j++) {
			if (j != 0) {
				System.out.print(" ");
			}
			System.out.print(result[j]);
			if (j != n - 1) {
				System.out.print(",");
			}
		}
		System.out.print(">");
	}

	public static void main(String[] args) {

		input();

	}

}
