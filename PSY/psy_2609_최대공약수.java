import java.util.Scanner;

public class psy_2609_최대공약수 {
	static int result1 = 1; //최대공약수
	static int result2 = 1; //최소공배수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int M = sc.nextInt(); 

		cal(N, M); // 재귀함수
		System.out.println(result1); //출력
		System.out.println(result2);
	}

	static void cal(int N, int M) {
		int num = Math.min(N, M); //최소값에서 1씩 내려가면서 나눠주기
		while (true) {
			if (num <= 1) { // 더이상 나눌게 없으면 return 및 최소공배수값 구해주기
				result2 = result1*N*M;
				return;				
			}
			if (N % num == 0 && M % num == 0) { //공통 약수로 나눠주기
				result1 *= num;
				cal(N / num, M / num);
				return;
			}
			num--;
		}
	}
}