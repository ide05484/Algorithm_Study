import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class psy_11053_가장긴수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N]; // 변수 담는 배열
		int[] result = new int[N]; // 결과값 담는 배열

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) { // 입력받기
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		result[0] = arr[0]; // 첫 숫자 삽입
		
		int count = 1; // 인덱스 위치 저장할 변수 선언
		
		for (int i = 1; i < N; i++) {
			if (arr[i] > result[count - 1]) { // 더 큰수 나오면 뒤에 저장
				result[count++] = arr[i];
				continue;
			}
			int idx = count;
			while (idx > 0) { // 작은수 나올경우 작은수 찾을떄 변경
				if (arr[i] > result[idx - 1]) {
					result[idx] = arr[i];
					break;
				}
				idx--;
				
				if (idx == 0) // 0번째 인덱스까지 가서 변경 못하면 최소값으로 바꿔주기
					result[idx] = Math.min(arr[i], result[idx]);
			}
		}
		
		for (int i = 0; i < N; i++) { // 출력
			if(result[i] == 0) {
				System.out.println(i);
				break;
			}
			if(i == N-1)
				System.out.println(N);
		}
		
	}
}
