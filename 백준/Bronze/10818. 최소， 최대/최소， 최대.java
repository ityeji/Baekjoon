import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int max = arr[0];

		int min = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// Arrays.sort로 푸는 방법

//		Arrays.sort(arr);
//		
//		int max = arr[n-1];
//		
//		int min = arr[0];

		System.out.println(min + " " + max);

	}

}
