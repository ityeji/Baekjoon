import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String num1 = sc.next();

		String num2 = sc.next();

		BigInteger bi1 = new BigInteger(num1);

		BigInteger bi2 = new BigInteger(num2);

		System.out.println(bi1.add(bi2));

	}

}