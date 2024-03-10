import java.util.Scanner;

public class psy_벌집_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int num = 0;
		int check;
		do {
			check = (int) (3 * Math.pow(num, 2) + 3 * num + 1); //일반항
			num++;
		} while (check < N);
		System.out.println(num);
	}
}
