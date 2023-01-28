
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		String s1 = "";

		List<String> arr = new ArrayList<>();

		while (t > 0) {

			int r = sc.nextInt();

			String s = sc.nextLine().trim(); // nextLine은 한 줄을 입력받으므로 trim이용해서 공백 없애기

			s1 = ""; // 다음 입력 String을 저장하기 위해 null로 초기화

			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < r; j++) {
					s1 += s.charAt(i); // String의 substring 사용(시작인덱스, 끝 인덱스)
					// String의 repeat 함수 사용 (문자열 반복)
				}
			}

			arr.add(s1);

			t--;
		}

		for (String s : arr) {
			System.out.println(s);
		}
	}

}
