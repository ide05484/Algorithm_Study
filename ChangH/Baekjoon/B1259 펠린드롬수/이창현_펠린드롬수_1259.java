package B1259;

import java.util.Scanner;

public class 이창현_펠린드롬수_1259 {
	static Scanner sc = new Scanner(System.in);//스캐너
	static String str; //숫자
	static boolean isf; //회문 여부
	public static void main(String[] args) {
		test(); //테스트 실행
	}
	private static void test() {
		testInput(); // 입력
		while(!str.equals("0")) { //입력값이 0이면 중단
			testProcess(); //실행
			testOutput(); //출력
			testInput(); //입력
		}
	}
	private static void testInput() {
		str=sc.nextLine(); //문장으로 받아옴
		isf=true; //일단 회문으로 간주
	}
	private static void testProcess() {
		for(int i = 0; i<str.length()/2; i++) { //홀수 일때는 중앙을 탐색할 필요 없고, 짝수일때는 중앙까지
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) { //처음부터 문장으로 받아서 탐색, 맨 앞과 맨 뒤에서부터 오면서 비교
				isf=false; //같지 않다면 펠림드롬 아님.
				return;
			}
		}
	}
	private static void testOutput() {
		if(isf) {
			System.out.println("yes"); //회!문
		} else {
			System.out.println("no"); //회?문
		}
	}
	
}
