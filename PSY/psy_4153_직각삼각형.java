import java.util.Scanner;

public class psy_4153_직각삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a == 0 && b == 0 && c == 0)
				break;
			if(a>b)
				b = swap(a,a=b);
			if(b>c)
			c =swap(b,b=c);
			if(a>b)
				b = swap(a,a=b);
			if(Math.pow(a,2)+Math.pow(b,2)==Math.pow(c,2))
				System.out.println("right");
			else
				System.out.println("wrong");
			
		}
		
	}
	
	static int swap(int a,int b) {
		return a;
	}
}
