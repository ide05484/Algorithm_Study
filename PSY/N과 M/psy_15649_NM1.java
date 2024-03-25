import java.util.Arrays;
import java.util.Scanner;

public class psy_15649_NM1 {
	static int M, N;
	static int[] res;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		res = new int[M];
		visited = new boolean[N + 1];
		comb(0);

	}

	static void comb(int a) {
		if (a == M) {
			for (int i = 0; i < M; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				res[a] = i;
				comb(a+1);
				visited[i]=false;
			}
		}

	}
}