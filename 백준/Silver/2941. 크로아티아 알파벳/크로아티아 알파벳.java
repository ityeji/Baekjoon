
import java.util.Scanner;

public class Main {

	static char[] strArr;

	static String s;

	static Scanner sc = new Scanner(System.in);

	static int count;

	public static void input() {

		s = sc.next();
		
		strArr = new char [s.length()];

		for (int i = 0; i < s.length(); i++) {
			strArr[i]=s.charAt(i);
		}

		solved();
	}

	public static void solved() {

		count = 0;
		
		int idx = 0;
		
		while (idx < strArr.length) {
			char alpha = strArr[idx];

			idx++;
			
			if (idx == strArr.length) {
				count++;
				break;
			}
			
			switch (alpha) {
			case 'c':
				if (strArr[idx] == '=' || strArr[idx] == '-') {
					idx++;
				}
				count++;
				break;
			case 'd':
				if (strArr[idx] == 'z') {
					if (idx + 1 <= strArr.length - 1 && strArr[idx+1] == '=') {

						idx = idx+2;
					}
				} else if (strArr[idx] == '-') {
					idx++;
				}
				count++;
				break;
			case 'l':
				if (strArr[idx] == 'j') {
					idx++;
				}
				count++;
				break;
			case 'n':
				if (strArr[idx] == 'j') {
					idx++;
				}
				count++;
				break;
			case 's':
				if (strArr[idx] == '=') {
					idx++;
				}
				count++;
				break;
			case 'z':
				if (strArr[idx] == '=') {
					idx++;
				}
				count++;
				break;
			default:
				count++;
			}
		}

	}

	public static void main(String[] args) {

		input();
		System.out.println(count);
	}

}
