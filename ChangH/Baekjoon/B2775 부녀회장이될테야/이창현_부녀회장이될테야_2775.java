package B2775;

import java.util.Scanner;

public class Main {
	static Scanner sc =new Scanner(System.in);
	static int T, k, n, result; //테스트케이스 갯수, k:층 n:호수, 결과값
	static int[][] apartment; //아파트
	public static void main(String[] args) {
		test(); //테스트
	}
	private static void test() {
		T=sc.nextInt(); //테스트 케이스 갯수
		for(int tc = 1; tc<=T; tc++) { //만큼 반복
			testInput(); //입력
			result = testProcess(k, n); //실행
			testOutput(); //출력
		}
	}
	private static void testInput() {
		k= sc.nextInt(); //층 입력
		n= sc.nextInt(); //호 입력
		apartment = new int[k+1][n+1]; //1씩 더해서 보드 생성
		for(int i = 0; i<=k; i++) {
			apartment[i][1]=1; //1호는 언제나 1명
		}
		for(int i = 0 ; i<=n; i++) {
			apartment[0][i]=i; //0층은 호수만큼 살음
		}
	}
	private static int testProcess(int r, int c) {
		if(apartment[r][c]!=0) { //비어있지 않다면 리턴
			return apartment[r][c]; 
		}
		return testProcess(r-1, c) + testProcess(r, c-1); //옆 호수와 바로 밑층 호수 인원을 더하면 인원
	}
	private static void testOutput() {
		System.out.println(result); //결과
	}
}
