import java.util.Scanner;
import java.util.Stack;

public class Main {

	// A진법으로 나타낸 숫자를 B진법으로 변환시켜주는 프로그램
	// A진법 -> 10진법 -> B진법으로 바꿔야함
	// A진법 -> 10진법 : string으로 받은 n진수 값을 Integer.parseInt(String s, int radix)함수에 넣어줌
	// 10진법 -> B진법 : 10진수를 제외한 나머지 진수는 String으로 받아야함.
	// Integer.toString(String s, int radix)사용하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int m = sc.nextInt();

		int result = 0;

		// a진수를 먼저 10진수로 바꿔주고
		// 10진수를 b진수로 바꿔주자
		// 10진수가 아니라면 -> String으로 받아야함

		// 아하! 자리수마다 공백으로 나눠서 주는 것이니...
		// 그냥 무작정 String에 넣어서 parseInt하면 안되겠구나
		// 예를 들어, 2 16으로 주어졌으면
		// 밑과 같으면 216이되어 3자리수가 될 수도 있고...
		// 의도 한 것은 2자리수인데...
//			String input = "";
//			for(int i = 0; i < m; i++) {
//				input += sc.next();
//			}
//			
//			int tmp = Integer.parseInt(input,a);

		// 일단 입력받는 즉시, 10진수로 해서 하나의 변수에 저장해버려야돼
		// 먼저 입력부터 받고 다 합쳐준 뒤에 10진수로 바꿔주면? -> 위와 같은 오류를 범하므로...
		for (int i = m - 1; i >= 0; i--) { // 자리수가 높은 것부터 입력받으므로 m-1 곱해주기(그래야 10진수가 된다)
			int input = sc.nextInt();
			result += input * (int) Math.pow(a, i);

		}

		// 입력 다 받으면 n진수로 바꿔줘야함
		// n진수로 바꾸는 방법?
		// 진수로 나눈 나머지를 나열해준다! (아래서부터!)
		// 스택을 사용하자!
		Stack<Integer> stack = new Stack<>();

		while (result > 0) {
			stack.push(result % b);
			result /= b;
		}

		// stack에서 하나씩 꺼내면?
		// 세로 나눗셈에서 아래 -> 위의 방향으로 나머지를 출력할 수 있다.
		// 맨 위의 나머지부터 stack에 들어가므로

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

	}
}