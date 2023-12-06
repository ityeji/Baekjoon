import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int [30];
		
		for(int idx = 0; idx < 28; idx++) {
			arr[sc.nextInt()-1]++;
		}
		
		for(int idx = 0; idx < 30; idx++) {
			if(arr[idx] == 0) {
				System.out.println(idx+1);
			}
		}

	}

}