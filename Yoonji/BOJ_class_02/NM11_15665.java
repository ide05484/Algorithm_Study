import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NM11_15665 {

	static Integer[] nums, result, arr;
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
		result = new Integer[M];

		st = new StringTokenizer(br.readLine(), " ");
		nums = new Integer[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Set<Integer>set = new HashSet<Integer>(Arrays.asList(nums));
		arr = set.toArray(new Integer[0]);
		Arrays.sort(arr);

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
		
		for (int i = 0; i < arr.length; i++) {
			result[idx] = arr[i];
			perm(idx + 1, visited | (1 << i));

		}

	}

}
