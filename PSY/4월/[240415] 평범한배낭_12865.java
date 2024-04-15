import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class psy_12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] weight = new int[N + 1];
		int[] value = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		int[][] arr = new int[N + 1][K + 1];

		for (int r = 1; r <= N; r++) {
			for (int c = 0; c <= K; c++) {
				if (weight[r] <= c) {
					arr[r][c] = Math.max(arr[r - 1][c], arr[r - 1][c - weight[r]] + value[r]);
				} else {
					arr[r][c] = arr[r-1][c];
				}
			}
		}
		System.out.println(arr[N][K]);
	}
}
