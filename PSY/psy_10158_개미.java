import java.util.Scanner;

public class psy_10158_개미 {
	static int t;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		int antR = sc.nextInt();
		int antC = sc.nextInt();
		t = sc.nextInt();
		
		System.out.println(ant(R,antR)+" "+ant(C,antC));
	}
	
	static int ant(int R,int antR) {
		int N = t % (R * 2);
		int num = 1;
		while(N > 0) {
			if(antR+num > R || antR+num < 0)
				num *= -1;
			antR += num;
			N--;
		}
		return antR;
	}
}
