import java.util.Scanner;

public class psy_12927_배수스위치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		char[] arr = new char[str.length()+1];

		for(int i = 1; i <= str.length();i++) {
			arr[i] = str.charAt(i-1);
		}
	
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]=='Y')
			{
				count++;
				for(int j = i;j < arr.length;j += i) {
					if(arr[j] == 'Y')
						arr[j] = 'N';
					else
						arr[j] = 'Y';
				}
			}
		}
		System.out.println(count);
	}
}
