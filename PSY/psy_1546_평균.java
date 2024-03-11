import java.util.Scanner;

public class psy_1546_평균 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		float[] score = new float[count];
		float[] new_score = new float[count];
		int max = Integer.MIN_VALUE;
		float sum = 0;
		
		for(int i = 0; i < count; i++) {
			score[i] = sc.nextInt();
			if(score[i] > max) {
				max = (int)score[i];
			}
		}
		for(int i = 0; i < count; i++) {
			new_score[i] = score[i]/max*100;
		}
		for(int i = 0; i < count; i++) {
			sum += new_score[i];
		}
		System.out.println(sum/count);
	}
}
