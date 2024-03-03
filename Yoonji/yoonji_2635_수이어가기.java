import java.util.ArrayList;
import java.util.Scanner;

public class yoonji_2635_수이어가기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int max = 0;
		ArrayList<Integer> maxList = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(N); // 첫 번째 수
			list.add(i); // 두 번째 수
			int temp = N - i;
			// 세 번째 수가 양수일 경우 while문
			// 뺀 수가 0일때도 포함임!
			while(temp >= 0) {
				list.add(temp);
				temp = list.get(list.size()-1-1) - list.get(list.size()-1);
			}
			// 지금까지 나온 수 중 최고 길이라면
			if(max < list.size()) {
				maxList.removeAll(maxList); // maxList 초기화 후
				max = list.size();
				maxList.addAll(list); // maxList에 현재까지 최고 길이 리스트 깊은 복사
			}
		}
		
		// maxList 출력
		System.out.println(max);
		for(int i = 0; i < maxList.size(); i++) {
			System.out.print(maxList.get(i) + " ");
		};
	}

}
