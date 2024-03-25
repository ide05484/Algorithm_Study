import java.util.Scanner;

public class psy_15649_NM2 {
	static int M, N;
	static int[] res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		res = new int[M];
		comb(1, 0);

	}

	static void comb(int a, int b) {
		if (b == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		if (a > N)
			return;
		res[b] = a;
		comb(a + 1, b + 1);
		res[b] = 0;
		comb(a + 1, b);

	}
}