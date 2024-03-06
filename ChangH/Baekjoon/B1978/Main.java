package B1978;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N, result, idx;
	static int[] Narr;
	static boolean[] isNotPrime;
	public static void main(String[] args) {
		test();
	}
	private static void test() {
		testInput();
		testProcess();
		testOutput();
	}
	private static void testInput() {
		N= sc.nextInt();
		Narr= new int[N];
		for(int i = 0; i<N; i++) {
			Narr[i] = sc.nextInt();
		}
		Arrays.sort(Narr);
		isNotPrime=new boolean[Narr[N-1]+1];
	}
	private static void testProcess() {
		while(Narr[idx]<=1) {
			idx++;
		}
		for(int i = 2; i<=Narr[N-1]; i++) {
			if(i== Narr[idx] && isNotPrime[i]) {
				idx++;
			}
			if(!isNotPrime[i]) {
				int tmp = i;
				if(tmp==Narr[idx]) {
					result++;
					idx++;
				}
				while(tmp<=Narr[N-1]) {
					isNotPrime[tmp] =true;
					tmp+=i;
				}
			}
		}
		
		
	}
	private static void testOutput() {
		System.out.println(result);
	}
}
