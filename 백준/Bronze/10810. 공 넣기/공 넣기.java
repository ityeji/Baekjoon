import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int [sc.nextInt()];
		
		int m = sc.nextInt();
		
		for (int idx = 0; idx < m; idx++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			
			for(int idx2 = i; idx2 <= j; idx2++) {
				arr[idx2-1] = k;
			}
		}
		
		for(int num: arr) {
			System.out.print(num + " ");
		}

	}

}