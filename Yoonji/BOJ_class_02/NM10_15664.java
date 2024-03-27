import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM10_15664 {

	static Integer[] nums, result, arr;
	static Integer N, M;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	// 시간초과가 나서 scanner에서 bufferedReader로 변경
	// 시간초과가 나서 bufferedWriter로 변경
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine(), " ");
		
		// 1부터 N까지 자연수 중
		N = Integer.parseInt(st.nextToken());
		// 중복 없이 M개를 고른 수열
		M = Integer.parseInt(st.nextToken());
		
		result = new Integer[M];
		
		// bufferedReader에서 readLine은 한줄씩이기 때문에 다시 설정해줌
		st = new StringTokenizer(br.readLine(), " ");
		nums = new Integer[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
//		Set<Integer>set = new HashSet<Integer>(Arrays.asList(nums));
//		arr = set.toArray(new Integer[0]);
		
		Arrays.sort(nums);
		
		perm(0, 0);

		bw.flush();
		bw.close();

	}

	 // idx: 결과 배열에 저장할 위치
    // start: 선택할 숫자의 시작 인덱스
    public static void perm(int idx, int start) throws IOException {
    	if (idx == M) {
			for (int i = 0; i < M; i++) {
				bw.write(result[i] + " ");
			}
			bw.write("\n");
			return;
		}
    	
    	int prev = -1; //이전에 선택한 숫자를 저장하기 위한 변수
        // 모든 원소를 돌면서 판단하겠다
        for (int i = start; i < N; i++) {
        	if(prev == nums[i]) continue;
        	prev = nums[i];//현재 숫자를 이전 숫자로 설정
            result[idx] = nums[i]; // 숫자 선택
            perm(idx + 1, i + 1); // 다음 재귀 호출은 다음 숫자부터 시작
            result[idx] = 0; // 숫자 제거 (재귀 호출 이후 되돌리기)
        }

    }

}
