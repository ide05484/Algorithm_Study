import java.util.Scanner;

public class psy_NQueen_9663 {
	static int N;
	static int[] col;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		col = new int[N];
		result = 0;
		queen(0);
		System.out.println(result);
	}

	static void queen(int r) {
		if (r == N) {
			result++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if (check(r, c)) {
				col[r] = c;
				queen(r + 1);
			}
		}
	}

	static boolean check(int r, int c) {
		for (int i = 0; i < r; i++) {
			if (col[i] == c || Math.abs(r - i) == Math.abs(c - col[i])) {
				return false;
			}
		}
		return true;
	}
}