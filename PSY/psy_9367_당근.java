import java.util.Scanner;

public class psy_9367_당근 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int N = sc.nextInt();
			int numBefore = 0;
			int count = 0;
			int min = 0;
			for (int j = 0; j < N; j++) {
				int num = sc.nextInt();
				if (numBefore < num) {
					count++;
					if (min < count)
						min = count;
				} else {
					if (min < count)
						min = count;
					count = 1;
				}
				numBefore = num;
			}
			System.out.println("#" + i + " " + min);
		}
	}
}
