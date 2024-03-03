import java.util.ArrayList;
import java.util.Scanner;

public class yoonji_2605_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		// N 만큼 반복
		for (int i = 1; i <= N; i++) {
			list.add(i);
			// 자리를 바꿔야 하는 인덱스
			int num = sc.nextInt();
			// 마지막꺼를 임시값에 넣어줌
			int temp = list.get(list.size() - 1);
			// 자리 바꿔야 하는 인덱스에 임시값을 넣어주고
			list.add(list.size() - 1 - num, temp);
			// 맨 뒤에 남아있는 원래 값을 지워줌
			list.remove(list.size() - 1);
		}
		//출력
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
