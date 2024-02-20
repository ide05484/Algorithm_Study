import java.util.Arrays;
import java.util.Scanner;

public class psy_2309_일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		int  a = 0;
		int b = 0;
		int tmp = 0;
		
		for(int i = 0 ; i < 9 ; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		sum -= 100;
		out : for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				if(i == j)
					continue;
				if(sum == arr[i]+arr[j]) {
					a = arr[i];
					b = arr[j];
					arr[i] = 0;
					arr[j] = 0;
					break out;
				}
			}
		}
		
		for(int i = 0 ; i < 8 ; i++) {
			for(int j = 0 ; j < 8 ; j++) {
				if(arr[j] > arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		for(int i = 2; i < 9 ; i++) {
			System.out.println(arr[i]);
		}
		
	}
}
