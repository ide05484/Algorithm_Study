import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class psy_1931_박상용 {
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting meeting) {
			if(end == meeting.end)
				return start - meeting.start; // 그 후 시작하는 시간 오름차순
			return -(meeting.end - end); // 끝나는 시간 비교 오름차순
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Meeting[] arr = new Meeting[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 입력받기
		}
		
		Arrays.sort(arr); // 정렬
		int result = 1; // 결과값 출력
		int start = arr[0].start; // 미팅 시작 시간 저장
		int end = arr[0].end; // 미팅 끝 시간 저장
		for(int i = 1; i < N; i++) { // index[0]은 무조건 해야함 그래서 1부터 돌기
				if(arr[i].start >= end) { // 끝난 이후에 시작 가능함으로 조건에 맞으면 결과값 올리고 예약
					result++;
					start = arr[i].start;
					end = arr[i].end;
				}
		}
		System.out.println(result); // 출력
	}
}
