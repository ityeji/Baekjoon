import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int [n];
		
		// 중간에 값 임시로 넣어줄 변수
		int tmp = 0;
		
		// 배열에 1부터 n까지 담아주기
		for(int idx = 1; idx <= n; idx++) {
			arr[idx-1] = idx;
		}
		
		// m번 바꿔준다
		for (int idx = 0; idx < m; idx++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			tmp = arr[i-1];
			arr[i-1] = arr[j-1];
			arr[j-1] = tmp;
		}
		
		for(int num : arr) {
			System.out.print(num + " ");
		}

	}

}