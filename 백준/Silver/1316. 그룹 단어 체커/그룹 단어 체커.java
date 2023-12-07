import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int result = 0; // 그룹 단어가 몇 개인지?

		for (int idx = 0; idx < n; idx++) {
			boolean groupCheck = true; // 일단 그룹 단어가 맞다고 판단
			char[] arr = sc.next().toCharArray(); // 일단 char로 나눈 후
//			if (arr.length == 1) {
//				groupCheck = true;
//			} 
			if (arr.length > 1) {
				for (int charIdx = arr.length - 1; charIdx >= 1; charIdx--) {

					for (int charIdx2 = charIdx - 1; charIdx2 >= 0; charIdx2--) {
						int idxDif = 0;
						if (arr[charIdx2] == arr[charIdx]) {
							idxDif = charIdx - charIdx2;

							if (idxDif == 1) {
								break;
							} else {
								groupCheck = false;
								break;
							}
						}
					}

				}
			}

			if (groupCheck) {
				result++;
			}
		}

		System.out.println(result);

	}

}