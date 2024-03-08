package B1259;

import java.util.Scanner;

public class 이창현_펠린드롬수_1259 {
	static Scanner sc = new Scanner(System.in);
	static String str;
	static boolean isf;
	public static void main(String[] args) {
		test();
	}
	private static void test() {
		testInput();
		while(!str.equals("0")) {
			testProcess();
			testOutput();
			testInput();
		}
	}
	private static void testInput() {
		str=sc.nextLine();
		isf=true;
	}
	private static void testProcess() {
		for(int i = 0; i<str.length()/2; i++) {
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) { //처음부터 문장으로 받아서 탐색
				isf=false; //같지 않다면 펠림드롬 아님.
				return;
			}
		}
	}
	private static void testOutput() {
		if(isf) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
	
}
