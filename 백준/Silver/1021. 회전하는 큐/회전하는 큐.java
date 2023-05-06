import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	// 현재 인덱스에서 다음 타깃 인덱스의 거리
	// 1. 다음 타깃 인덱스 - 현재 인덱스 = 1
	// -> 1번 연산이니 카운트 x, 그냥 poll만 해준다.
	// 2. 1보다 커 -> 카운트 o
	// -> 인덱스 0에서 다음 타겟까지의 거리 vs n에서 다음 타켓까지의 거리(절댓값)
	// -> 전자가 더 작으면? -> 앞에서 빼서 뒤로 넣기
	// -> 후자가 더 작으면? -> 뒤에서 빼서 앞으로 넣기

	// 위의 방법으로 하려했더니... 너무 복잡해!!
	// 구글링 해보니, 중간값보다 작으면 왼쪽으로 움직이는 게 더 빠르고, 중간값보다 크면 오른쪽으로 움직이는 게 더 빠르다!

	static Scanner sc = new Scanner(System.in);
	static int n; // 큐의 크기
	static int m; // 뽑아내려고 하는 수의 개수
	static ArrayDeque<Integer> deque;
	static int count;

	public static void input() {
		deque = new ArrayDeque<>();
		count = 0;

		// 큐의 크기만큼 일단 0 채워주기
		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			deque.add(i);
		}

		// 뽑아내려 하는 수
		m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			int num = sc.nextInt();

			solved(num);
		}
	}

	public static void solved(int num) {

		// num이 해당 덱에서 앞쪽에 있냐 뒤쪽에 있냐에 따라
		// 앞쪽이면 앞의 것을 뒤로 보내주고
		// 뒤쪽이면 뒤의 것을 앞으로 보내준다
		// 덱에 있는 내장함수를 사용하고 싶은데...
		// 구글링 해보니 Iterator를 사용하면 hasNext()와 next()메소드를 사용할 수 있구나!
		// hasNext는 boolean타입, next는 Iteraor 인터페이스에 저장되어있는 값으로 반환!

		while (true) {
			int idx = 0; // 몇 번째 인덱스인지 찾기
			Iterator<Integer> iter = deque.iterator();
			while (iter.hasNext()) {
				if (iter.next() == num) { // 다음이 num과 같다.
					break;
				}
				idx++;
			}

			if (idx == 0) {
				// 바로 앞의 숫자가 num과 같다면?
				deque.pollFirst();
				break; // 제거 했으니 다음 순번으로 넘어가자
			} else if (idx > deque.size() / 2) {
				deque.offerFirst(deque.pollLast());
				count++;
			} else {
				deque.offerLast(deque.pollFirst());
				count++;
			}
		}
	}

	public static void main(String[] args) {

		input();
		System.out.println(count);

	}

}