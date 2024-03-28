import java.util.Scanner;

public class psy_1676_팩토리얼0개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(N / 5 + N / 25 + N / 125);
	}
}
