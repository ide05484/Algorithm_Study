import java.util.ArrayList;
import java.util.Scanner;

public class psy_2635_수이어가기 {
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int max = 0;
		int result = 0;
		for(int i = num; i >0;i--) {
			int count = pibo(num,i);
			if(count > max) {
				max = count;
				result = i;
			}
		}
		System.out.println(max);
		list = new ArrayList<>();
		list.add(num);
		list.add(result);
		piboArr(num, result);
		for(int i = 0;i < list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	
	static int pibo(int num,int i) {
		if(num-i<0)
			return 2;
		return pibo(i,num-i)+1;
	}
	
	static void piboArr(int num,int i) {
		if(num-i<0)
			return;
		list.add(num-i);
		piboArr(i, num - i);
	}
}
