import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	// 집합 문법인 HashSet을 이용하자!

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Set<Integer> a = new HashSet<>(); // a집합 입력
		Set<Integer> b = new HashSet<>(); // b집합 입력

		int alength = sc.nextInt();
		int blength = sc.nextInt();

		for (int i = 0; i < alength; i++) {
			a.add(sc.nextInt());
		}

		for (int i = 0; i < blength; i++) {
			b.add(sc.nextInt());
		}

		// a집합에 b집합에 해당하는 것들 지울거고(메소드 a집합.removeAll(b집합))
		// 반대로 b집합에 a집합에 해당하는 것들 지울 것이므로 (b집합.removeAll(a집합)
		// 입력된 a집합을 복사해야한다.
		Set<Integer> copyA = new HashSet<>(a);

		a.removeAll(b); // a-b
		b.removeAll(copyA); // b-a

		// 차집합의 합을 구해야하므로(총 개수가 몇 개인지?)
		// 한 곳에 몰아서 차집합 원소를 더해주자
		a.addAll(b);

		System.out.println(a.size()); // 원소 개수 출력

	}

}