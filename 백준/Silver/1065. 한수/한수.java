import java.util.Scanner;

public class Main {

	// 양의 정수 x의 각 자리가 등차수열을 이룬다면 -> 한수
	// 처음에 이 말 뜻을 이해잘못함...
	// 만약, 999라면 -> 각 자리의 수 (백의 자리 9, 십의 자리 9, 일의 자리 9)
	// 공차 0인 등차수열이 되므로 999는 한수!

	// 자, 여기서 1~9는 한수!
	// 일의 자리수니까....

	// 10~99도 한수!
	// 1하고 0, 9하고 9보면 알겠지만 어차피 등차수열의 원소가 2개니...

	// 그럼 100부터 검사하면 되겠다!

	// 한수의 최댓값을 구하는 것으로 문제를 잘못이해해서
	// result = i; 로 result값을 갱신해주려했으나!
	// 문제에서는 한수의 갯수를 구해주는 거였다!
	// 그러므로, 한수가 나올 때마다 result + 1을 해줘야지

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int result = 0;

		// 1부터 검사해보자(for)
		for (int i = 1; i <= n; i++) {
			if (i <= 99) {
				result = i;
			} else {
				// int 배열에 담아서 풀고싶어서 나누기 했더니,,,
				// 이상한 값이 들어가니까
				// String으로 해서 자리수로 쪼개고(split)
				// 쪼갠 것을 String 배열에 넣어서
				// 배열의 원소를 ParseInt 하자!

				String[] arr = Integer.toString(i).split(""); // ""로 tmp를 자르기

				if ((Integer.parseInt(arr[1]) - Integer.parseInt(arr[0])) == (Integer.parseInt(arr[2])
						- Integer.parseInt(arr[1]))) {
//					result = i;
					result += 1;
				}
			}
		}

		System.out.println(result);

	}

}