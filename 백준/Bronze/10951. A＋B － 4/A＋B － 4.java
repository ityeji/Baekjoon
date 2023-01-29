
import java.util.Scanner;

public class Main {

	// 다음 입력값이 기다리고 있냐 없냐 hasNext
	// 입력값이 한 번에 들어가서

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) { // 입력된 값이 Int형일 경우 true
			// sc.nextInt에 값이 안들어왔는데, while이 동작하는 이유
			// 디폴트가 10으로 설정되어 있기 때문
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(a + b);
		}
	}
}
