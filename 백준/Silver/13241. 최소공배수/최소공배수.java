import java.util.Scanner;

public class Main {

	// 유클리드 호제법
	// 최대공약수를 먼저 구하고, 최소공배수를 구하자
	// 최대공약수: 큰 수를 작은 수로 나눈 나머지를 반복적으로 취햐여 나머지가 0이 될 때까지 작동 (0이 되는 타이밍에 나눈 수가 최대공약수)
	// 최소공배수: 두 수 곱한 값을 최대공약수로 나눈 값

	// 재귀 방식으로 구현한다.

	// 최대공약수
	public static long gcf(long a, long b) {

		// base case
		if (b == 0) {
			// 나머지가 0이 되면 a가 최대공약수가 됨.
			return a;
		}

		// 반복해서 나머지가 0이 될 때까지 나눠줘야하므로
		return gcf(b, a % b);
	}

	// 최소공배수
	public static long lcm(long a, long b) {
		return a * b / gcf(a, b);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.println(lcm(a, b));

	}

}