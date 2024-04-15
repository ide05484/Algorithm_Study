import java.util.Scanner;

public class psy_2294_동전2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 동전 가치 개수
		int k = sc.nextInt(); // 거스름돈
		int[] coin = new int[n]; // 동전 가치 배열
		for (int j = 0; j < n; j++) { // 입력받기
			coin[j] = sc.nextInt();
		}

		int[] result = new int[k + 1]; // 해당 가치에 얼만큼 저장되는지 기록
		for (int j = 1; j <= k; j++) {
			int min = 1000000; //최소값 설정
			for (int i = 0; i < n; i++) {
				if (j >= coin[i]) { // 더 적은 경우로 채울 수 있다면 갱신
					min = Math.min(min, result[j - coin[i]] + 1);
				}
			}
			result[j] = min;
		}
		System.out.println(result[k] < 1000000 ? result[k] : -1); // 출력
	}
}
