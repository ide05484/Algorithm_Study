import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM_15650 {

    static int[] nums, result;
    static int N, M;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1부터 N까지 자연수 중
        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }

        // 중복 없이 M개를 고른 수열
        M = Integer.parseInt(st.nextToken());
        result = new int[M];
        perm(0, 0);

    }

    // idx: 결과 배열에 저장할 위치
    // start: 선택할 숫자의 시작 인덱스
    public static void perm(int idx, int start) {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        // 모든 원소를 돌면서 판단하겠다
        for (int i = start; i < N; i++) {
            // 이미 선택된 숫자는 건너뛴다
            //if (result[idx] != 0) continue;
            result[idx] = nums[i]; // 숫자 선택
            perm(idx + 1, i + 1); // 다음 재귀 호출은 다음 숫자부터 시작
            result[idx] = 0; // 숫자 제거 (재귀 호출 이후 되돌리기)
        }

    }

}
