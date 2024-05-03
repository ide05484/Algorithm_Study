import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class psy_2115_벌꿀채취 {
	static int N, M, C, cal, max;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 벌집 크기
			M = Integer.parseInt(st.nextToken()); // 한번 수확 크기
			C = Integer.parseInt(st.nextToken()); // 제한

			arr = new int[N][N]; // 벌집 배열 생성
			for (int r = 0; r < N; r++) { // 입력받기
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0; // 결과 값 입력받기
			comb(0, 0, 0, 0); // 조합으로
			System.out.println("#" + i + " " + max);
		}
	}

	static void comb(int count, int r, int c, int sum) { // r,c 좌표와 합한 결과 넘겨주기
		if (count == 2) { // 2개의 벌집 골랐을때 최대값이면 갱신
			max = Math.max(max, sum); 
			return;
		}

		out : for (int j = r; j < N; j++) {
			for (int k = c; k < N; k++) {
				if(k + M > N) { // 해당 행을 더 못보면 다음 행으로 넘어감
					c = 0; // **넘어갈 때 0의 위치부터 봐야됨 중요
					continue out;
				}
				cal = 0; // 한 벌집에서 최대값
				calculate(0, j, k, 0, 0); // 한 벌집에서 최대값 구해주기
				if (k + 2 * M > N) { // 해당행에서 못보면 다음 행으로 넘어가기
					comb(count + 1, j+1, 0, sum + cal);
				} else {
					comb(count + 1, j, k+M, sum + cal);
				}
			}
		}

	}

	private static void calculate(int count, int r, int c, int honey, int honeyjegob) {
		if(honey > C) // 제한 범위 넘어가면 리턴
			return;
		if(count == M) { // 끝까지 봤으면 최대값 갱신
			cal = Math.max(cal,honeyjegob);
			return;
		}
		
		calculate(count+1, r, c+1, honey+arr[r][c], (int) (honeyjegob+Math.pow(arr[r][c], 2))); // 벌꿀집 pick
		calculate(count+1, r, c+1, honey, honeyjegob); // 벌꿀집 no pick
	}
}
