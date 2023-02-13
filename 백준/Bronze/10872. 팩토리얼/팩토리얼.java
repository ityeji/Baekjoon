
import java.util.Scanner;

public class Main {

	// 팩토리얼
	// 자기 자신부터 시작해서
	// 하나씩 작아지면서 곱해짐
	// 재귀함수 쓸거지롱

	static int solved(int num) {

		if (num == 0) {
			return 1;
		} else {
			return num * solved(num - 1);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(solved(sc.nextInt()));

	}

}
