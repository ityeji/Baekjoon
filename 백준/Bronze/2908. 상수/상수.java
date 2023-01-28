
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		// 상근이가 생각하는 수
		int n1_sang = 0;
		int n2_sang = 0;

		// 나머지 구해서, 반복될때마다 10씩 곱해서 상근이가 생각하는 수에 넣어주기
		int na = 0;

		// n1_sang 구하기
		for (int i = 1; i < 4; i++) {
			// 한 자리씩 10의 i제곱으로 원래 데이터 나눠서 나머지로 구하기
			na = (int) ((n1 - na) % Math.pow(10, i)); // Math.pow -> 거듭제곱구하기(double형)

			// 위의 식은 나머지가 일의 자리, 십의 자리, 백의 자리로 나오므로,
			// 반복문 돌리면서 위에서 나온 나머지를 10의 i제곱으로 나눠주기
			n1_sang = (int) ((n1_sang * 10) + (na / Math.pow(10, i - 1)));
		}

		na = 0; // na 재사용을 위한 초기화

		for (int i = 1; i < 4; i++) {
			na = (int) ((n2 - na) % Math.pow(10, i)); // Math.pow -> 거듭제곱구하기(double형)

			n2_sang = (int) ((n2_sang * 10) + (na / Math.pow(10, i - 1)));
		}

		System.out.println(Integer.max(n1_sang, n2_sang));

	}

}
