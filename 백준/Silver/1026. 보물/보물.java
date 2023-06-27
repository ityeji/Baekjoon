import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// a의 가장 큰 값 * b의 가장 작은 값
	// 둘 다 list로 저장시켜서 Collections.min(max) // Collections.remove사용하기
	// Collections.remove(Integer.valueOf(min(max)))를 사용해야하는데
	// 그 이유는?
	// 둘 다 list<Integer>이기 때문에, Integer.valueOf()를 써서 Integer 클래스 타입으로 숫자를 만들어줘야함.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}

		for (int i = 0; i < n; i++) {
			b.add(sc.nextInt());
		}

		int sum = 0; // 따로 min을 구할 필요는 없다.
		// 어차피 처음부터 sum이 최솟값이 나오게끔 연산할 거니까!

		for (int i = 0; i < n; i++) {
			// n번 연산을 해야함

			// A의 최솟값과 B의 최댓값의 곱
			int min = Collections.min(a);
			int max = Collections.max(b);

			sum += (min * max);

			// 계산한 값 리스트에서 지우기
			a.remove(Integer.valueOf(min));
			b.remove(Integer.valueOf(max));
		}

		System.out.println(sum);

	}

}