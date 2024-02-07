import java.math.BigInteger;
import java.util.Scanner;

public class psy_1914 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = itoa(N);
		BigInteger result = new BigInteger(str);
		System.out.println(power(result).subtract(new BigInteger("1")));
		if(N<=20)
		move(N, 1, 3, 2);
	}
	
	static String itoa(int N) {
		int num = 0;
		for(int i = 1; N / i > 0;i*=10) {
			num = i;
		}
		String str = new String();
		for(int i = num; i > 0;i/=10) {
			str+= N / i;
			N %= 10;
		}
		return str;
	}
	
	static BigInteger power(BigInteger N) {
		if(N.compareTo(new BigInteger("1")) == -1) {
			return new BigInteger("1");
		}
		return new BigInteger("2").multiply(power(N.subtract(new BigInteger("1"))));
	}
	
	static void move(int count,int from,int to,int tmp) {
		if(count == 0)
			return;
		move(count-1,from,tmp,to);
		System.out.println(from+" "+to);
		move(count-1,tmp,to,from);
		
	}
}
