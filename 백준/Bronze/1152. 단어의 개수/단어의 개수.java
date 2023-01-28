
import java.util.Scanner;

public class Main {

	// 바로 split을 쓰면, enter를 눌렀을 때 값이 들어가게 된다. (빈 문자열로 실제값이 존재하게 됨)
	// strip: 앞 뒤 공백 제거 (trim보다 공백이라 인식하는 범위가 더 넓음)
	// stripLeading(): 문자열 앞의 공백 제거
	// stripTrailing: 문자열 뒤의 공백 제거
	// trim : 앞 뒤 공백 제거한다

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine().strip();

		// 앞 뒤 공백 제거한 해당 문자열이 빈 문자열인지 확인하자
		// arr에 아무것도 입력 안됐을 경우 생각! -> 백준에서는 인덱스 에러 남

		if (s.equals("")) {
			System.out.println(0);
		} else {

			String[] arr = s.split(" ");

			System.out.println(arr.length);
		}
	}
}
