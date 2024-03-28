
import java.util.Arrays;
import java.util.Scanner;

public class psy_11724_연요개 {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 정점 개수
		int M = sc.nextInt(); // 간선 개수

		p = new int[N + 1]; // 연결 배열

		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}
		int count = 0;
		for (int i = 0; i < M; i++) {
			int a = findset(sc.nextInt()); // 제일 높은 애 찾기
			int b = findset(sc.nextInt());
			if (a != b) { // 집합이 아니라면 합쳐주기
				p[a] = b; // 집합 합해주기
			}
		}
		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) { // 결과 배열
			result[findset(i)]++;
		}
		for (int i = 1; i <= N; i++) { // 갯수 세기
			if(result[i] != 0)
				count++;
		}
		System.out.println(count);

	}

	static int findset(int i) {
		if (i != p[i])
			p[i] = findset(p[i]);
		return p[i];
	}
}
