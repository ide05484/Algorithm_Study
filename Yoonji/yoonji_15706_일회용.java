import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 일회용_15706 {
	public static void main(String[] args) {
		
		int T = 1;
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = 7;
			int k_min = 1;
			int k_max = 6;
			 
			int[] arr = {3, 3, 5, 2, 5, 1, 2};
			
			
			// 최소 기준에 맞추어 분반이 가능한지 확인하기 위해
			// 점수들이 몇개있는지 확인
			Set<Integer> set = new HashSet<>();
			for(int i = 0; i < N; i++) {
				set.add(arr[i]);
			}
			// 세 반으로 편성이 안되면 -1 출력하고 다음 반복문
			if(set.size() < k_min * 3) {
				System.out.println("#" + tc + " " + -1);
				continue;
			}
			
			Arrays.sort(arr);
			
			System.out.println(Arrays.toString(arr));
			
			ArrayList<Integer> classA = new ArrayList<Integer>();
			ArrayList<Integer> classB = new ArrayList<Integer>();
			ArrayList<Integer> classC = new ArrayList<Integer>();

			/*
			 * 분반마다 어레이리스트에 저장해서
			 * 최대값 - 최소값으로 하려는데
			 * 접근 방법을 어떻게 해야 할지 모르겠습니다.
			 */
			
		}
	}
}
