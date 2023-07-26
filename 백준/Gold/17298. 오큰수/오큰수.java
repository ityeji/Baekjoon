import java.util.Scanner;
import java.util.Stack;

public class Main {

	// 임시 스택과 정답 스택을 만든다.
	// 입력 값을 배열에 넣고 오른쪽부터 순서가 돌아간다.
	// 임시 스택은 오른쪽부터 숫자를 쌓은 스택
	// case1) 임시 스택 내용 존재 O -> 현재 값이 임시 스택의 top보다 크거나 같을동안 임시 스택 pop -> 오른쪽 수는 왼쪽
	// 수보다 커야하므로
	// case2) 임시 스택 내용 존재 X -> 정답 스택에 -1 쌓기 -> 오른쪽에 자신보다 큰 수가 없음을 나타냄
	// case2-2) 임시 스택 값 O -> 임시 스택의 top 값을 정답 스택에 push -> 이때, peek 사용!
	// case3) 현재 값을 임시 스택에 쌓기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] input = new int[n];

		// 시간 초과 뜨니까 StringBuilder쓰자!
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		Stack<Integer> ans = new Stack<>();
		Stack<Integer> tmp = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {
			int num = input[i];

			// 임시 스택에 값이 있으면
			// 현재 값(num)과 비교하여 num이 같거나 크면 임시 스택에서 pop 해주기
			while (!tmp.isEmpty() && (num >= tmp.peek())) {
				tmp.pop();
			}

			// 위의 과정이 다 끝났는데..
			// 만약 임시 스택이 비어있다면?
			if (tmp.isEmpty()) {
				ans.add(-1);
			} else {
				// 안비어있다면?
				// peek해서 정답 스택에 쌓아주기
				ans.add(tmp.peek());
			}

			// 위의 과정 다 끝났으면 현재 값 임시 스택에 쌓아주기
			tmp.add(num);
		}

		// 정답 출력
		while (!ans.isEmpty()) {
			sb.append(ans.pop() + " ");
		}

		System.out.println(sb);

	}

}