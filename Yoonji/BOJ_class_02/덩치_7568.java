import java.util.Scanner;

// Person 클래스 선언: 사람의 몸무게와 키
class Person {
	int weight;
	int height;

	public Person(int weight, int height) {
		super();
		this.weight = weight;
		this.height = height;

	}
	
}

public class 덩치_7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// Person 객체 배열 생성
		Person[] people = new Person [N];
		
		// Person 객체 생성
		for(int i = 0; i < N; i++) {
			int height = sc.nextInt();
			int weight = sc.nextInt();
			people[i] = new Person(height, weight);
		}
		
		// 각 사람에 대하여 비교
		for(int i = 0; i < N; i++) {
			// 등수는 모두 1로 설정하고
			int rank = 1;
			// 모든 사람들에 대해서 비교할 때
			for(int j = 0; j < N; j++) {
				// 자기 자신과의 비교는 건너뛰고
				if(i==j) continue;
				// 현재 사람 i 보다 덩치가 큰 사람이 있으면
				if(people[i].weight < people[j].weight && people[i].height < people[j].height) {
					// 등수를 증가시킨다
					rank++;
				}
			}
			// 현재 사람에 대한 등수 출력
			System.out.print(rank + " ");
		}		
		
	}
}
