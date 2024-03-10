import java.util.Scanner;

public class psy_팰린드롬수_1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String str1 = sc.next();
			if (str1.equals("0"))
				break;
			String str2 = "";
			for (int i = str1.length() - 1; i >= 0; i--)
				str2 += str1.charAt(i);
			if (str1.equals(str2))
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
