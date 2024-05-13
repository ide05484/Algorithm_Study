import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class psy_18111_마크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken()); // 가로
		int C = Integer.parseInt(st.nextToken()); // 세로
		int B = Integer.parseInt(st.nextToken()); // 가방
		int[] arr = new int[257]; // 카운팅 배열
		int min = 256; // 최소 가능 층
		int max = 0; // 최대 가능 층
		
		for (int i = 0; i < R; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[num]++;
				min = Math.min(min, num); // 최소값 갱신
				max = Math.max(max, num); // 최대값 갱신
			}
		}
		
		int resulttime = Integer.MAX_VALUE; // 출력 시간
		int resultheight = 0; // 출력 높이
		out: for (int i = min; i <= max; i++) { // 현재 맞출 높이
			int tmptime = 0; // 임시 시간
			int tmp = B; // 임시 가방
			for (int j = max; j >= min; j--) { // 지금 있는 층
				if (i < j) { 
					tmp += (j - i) * arr[j];
					tmptime += 2 * arr[j] * (j-i);
				} else if (i > j) {
					tmp -= (i - j) * arr[j];
					tmptime += arr[j]* (i-j);
				}
				if (tmp < 0) // 가방이 음수면 더 볼것도 없다
					break out;
			}
			if(tmptime <= resulttime) { // 갱신
				resulttime = tmptime;
				resultheight = i;
			}
		}
		System.out.println(resulttime+" "+resultheight);
	}
}
