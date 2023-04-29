import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 재귀를 돌리자~
	// 병합정렬 느낌으로
	// 분할해서 재귀 돌려주자
	// 가운데 부분을 공백으로 바꿔주니
	// 가운데를 기준으로!

	static int num;
	static StringBuilder result; // 중간 문자열을 공백으로 바꾸는 것을 setCharAt(인덱스, '처리할 문자')로 나타낼 건데
// setCharAt은 StringBuilder의 내장메소드

	static void input() throws IOException {

		// tc가 없이 마구잡이로 숫자가 입력되므로
		// BufferedReader를 쓰자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		// BufferedReader는 개행문자만 경계로 인식하고.
		// 입력받은 데이터가 String으로 고정된다.
		// 그래서, 따로 데이터를 가공해야한다.
		while ((str = br.readLine()) != null) {
			num = Integer.parseInt(str);
			result = new StringBuilder();

			// 재귀 돌릴 때, 사이즈가 1이되면 재귀 멈추라고 할 것이기 때문에
			// 사이즈를 담을 변수를 만들어주는 것이 좋다.
			int len = (int) Math.pow(3, num);

			for (int i = 0; i < len; i++) {
				// StringBuilder에 넣어준다.
				result.append("-");
			}

			cut(0, len);
			System.out.println(result);
		}
	}

	static void cut(int idx, int size) {

		// 기저조건
		if (size == 1) {
			return;
		}

		int cutSize = size / 3;

		for (int i = idx + cutSize; i < idx + (2 * cutSize); i++) { // 삼등분해서 중간을 공백으로 바꾸는 것이니까
			// 그러니 공백 시작 인덱스는 3등분 사이즈를 시작 인덱스에 더한 곳에서 시작해서
			// 3등분한 사이즈의 2배 인덱스 까지
			result.setCharAt(i, ' ');

		}

		// 왼쪽도 위의 과정 해주고
		// 오른쪽도 위의 과정 해주고
		cut(idx, cutSize);
		cut(idx + (2 * cutSize), cutSize);
	}

	public static void main(String[] args) throws IOException {
		input();
	}
}