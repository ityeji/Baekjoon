
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		if (a >= 100 && b >= 100 && c >= 100 && a < 1000 && b < 1000 && c < 1000) {
			int mul = a * b * c;
			String s = Integer.toString(mul); // int를 string으로 형변환

			// s를 char 배열에 저장
			char[] arr = s.toCharArray();

			// 해당 숫자 인덱스 값을 ++
			// 인덱스 값 ++ 해줄 배열 생성
			int[] idx = new int[10];
			for (char ch : arr) {
				idx[ch - 48]++;
			}

			// 빈도수 저장 배열 인덱스 출력
			for (int i : idx) {
				System.out.println(i);
			}

		}

	}

}
