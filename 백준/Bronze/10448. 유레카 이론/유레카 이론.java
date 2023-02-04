
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 배열을 만들어서
		// T값을 n인덱스 요소로 넣고
		// 삼중 for문을 이용해 하나씩 꺼내서 더해주어
		// 입력 값과 딱맞는 요소가 3개이면 1출력
		// 아니면? 0출력

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		int[] arr = new int[t]; // 값 입력받기

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int[] tValue = new int[44]; // for문 돌려서 각 인덱스에
		// 해당 인덱스의 T값을 저장하자

		for (int i = 1; (i * (i + 1)) / 2 < 1000; i++) {
			tValue[i - 1] = (i * (i + 1)) / 2;
		}
//
//		// 삼각수 합 저장할 2차원 배열
//		int[] hap = new int[t * t * t];

		// 결과값 한 번에 출력하기 위해 배열로 저장
		int[] result = new int[t];
		// hap 저장할 때 쓰일 인덱스
		int idx = 0;
		while (idx < t) {

			result[idx] = 0; // 일단 없다고 생각하고 초기화

			// 삼중for문 돌려서 3개 합이 담긴 배열 만들기
			for (int i = 0; i < tValue.length; i++) {
				for (int j = 0; j < tValue.length; j++) {
					for (int z = 0; z < tValue.length; z++) {
						if (tValue[i] + tValue[j] + tValue[z] == arr[idx]) {
							result[idx] = 1; // 있으면 1 저장
						}
					}
				}
			}
			idx++;
		}

		// 결과값 출력
		for (int i : result) {
			System.out.println(i);
		}
	}

}
