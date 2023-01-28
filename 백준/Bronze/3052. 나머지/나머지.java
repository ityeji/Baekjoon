

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	// 중복된 것을 찾아야할 때는 hashset를 사용하자!

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 숫자 입력
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}

		// 나머지 저장 배열
		int[] na = new int[10];
		for (int i = 0; i < na.length; i++) {
			na[i] = arr[i] % 42;
		}

		// HashSet을 사용하여 중복 없애기
		Set<Integer> naset = new HashSet<>();

		// 나머지가 저장되어있는 na 배열을 set에 넣어주기
		for (int i = 0; i < na.length; i++) {
			naset.add(na[i]);
		}

		System.out.println(naset.size());

	}

}
