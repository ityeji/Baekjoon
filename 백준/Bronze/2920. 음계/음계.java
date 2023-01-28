
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = bf.readLine().split(" ");

		// String배열을 Int배열로 바꾸기
		int[] iarr = new int[arr.length];

		for (int i = 0; i < iarr.length; i++) {
			iarr[i] = Integer.parseInt(arr[i]);
		}

		// switch - case문으로 몇 번부터 시작하는지 분류하고
		// for문 돌려서 순서대로인지? 마구잡이인지? 확인하자!
		// 결과값 저장
		String result = "";

		switch (iarr[0]) {
		case 1:
			for (int i = 0; i < iarr.length; i++) {
				if (iarr[i] == (i + 1)) {
					result = "ascending";
				} else {
					result = "mixed";
					break;
				}
			}
			break;
		case 8:
			for (int i = 0; i < iarr.length; i++) {
				if (iarr[i] == (8 - i)) {
					result = "descending";
				} else {
					result = "mixed";
					break;
				}
			}
			break;
		default:
			result = "mixed";
		}

		System.out.println(result);

	}

}
