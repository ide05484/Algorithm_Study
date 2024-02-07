package swea6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class psy_2628 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int num = sc.nextInt();
		int[][] arr = new int[N][M];
		List<Integer> arrN = new ArrayList<>();
		List<Integer> arrM = new ArrayList<>();
		arrN.add(0);
		arrN.add(N);
		arrM.add(0);
		arrM.add(M);
		for(int i = 0; i < num; i++) {
			if(sc.nextInt() == 1) {
				arrN.add(sc.nextInt());
			}else {
				arrM.add(sc.nextInt());
			}
		}
		arrN.sort(Comparator.naturalOrder());
		arrM.sort(Comparator.naturalOrder());
		int MaxN = 0;
		int MaxM = 0; 
		for(int i = 0; i < arrN.size() - 1;i++) {
			if(MaxN < arrN.get(i+1)-arrN.get(i)) {
				MaxN = arrN.get(i+1)-arrN.get(i);
			}
		}
		for(int i = 0; i < arrM.size() - 1;i++) {
			if(MaxM < arrM.get(i+1)-arrM.get(i)) {
				MaxM = arrM.get(i+1)-arrM.get(i);
			}
		}
		System.out.println(MaxM * MaxN);
	}
}
