import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class NM09_15663 {

	static int[] nums, result;
	static int N, M;
	static boolean[] visited; // 해당 원소 사용 유무
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		result = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		perm(0,0);

		bw.flush();
		bw.close();
		br.close();
	}

	// idx: 결과 배열에 저장할 위치
	// visited: 사용한 원소의 위치를 기록하기 위한 정수
	public static void perm(int idx, int visited) throws IOException {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				bw.write(result[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		int prev = -1; //이전에 선택한 숫자를 저장하기 위한 변수
		// 모든 원소를 돌면서 판단하겠다
		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) != 0 || prev == nums[i]) continue;
			// 아래의 코드가 실행된다는 것은 i번째 원소를 하용하지 않았다는 것
			prev = nums[i];//현재 숫자를 이전 숫자로 설정
			result[idx] = nums[i];
			perm(idx + 1, visited | (1 << i));

		}

	}

}
