import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		sc.nextLine(); // nextInt는 사용자가 입력한 enter를 제거하지 않기 때문에,
		// 남겨진 개행문자가 다음 nextLine()의 입력으로 처리되어 바로 실행된다.

		if (n >= 1 && n <= 100) {

			// 값은 일단 String으로 받자
			String s = sc.next();

			// 문자열을 문자배열로 변환 -> toCharArray()
			char[] arr = s.toCharArray();

			// char로 0은 아스키코드 48이다 -> int로 바꾸면 48 나온다
			// 일단 합 저장할 변수 만들자
			int sum = 0;

			for (int i = 0; i < arr.length; i++) {
				sum += (arr[i] - 48); // 그러니 배열요소에 48빼자
				// arr은 char형이므로 int형으로 굳이 형변환 필요 없다
			}

//			long sum = 0;
//
//			long na = 0; // 나머지 저장
//
//			// for문 돌려서 10의 i제곱으로 나눈 나머지의 합
//			for (int i = 1; i <= n; i++) {
//				sum += ((n2 - na) % (10 ^ i));
//				na = (n2 % (10 ^ i));
//			}

			System.out.println(sum);

		}

	}

}
