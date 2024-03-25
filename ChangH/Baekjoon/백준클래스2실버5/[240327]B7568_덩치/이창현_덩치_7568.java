package B7568;

import java.util.Scanner;

class Person{
	int weight;
	int height;
	Person(int weight, int height){
		this.weight = weight;
		this.height = height;
	}
}

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Person[] list;
	static int N, X, Y, cnt;
	static String result;
	public static void main(String[] args) {
		test();
	}
	private static void test() {
		testInput();
		testProcess();
		testOutput();
	}
	private static void testInput() {
		N = sc.nextInt();
		list = new Person[N];
		for(int i = 0 ; i<N; i++) {
			X = sc.nextInt();
			Y = sc.nextInt();
			list[i] = new Person(X, Y);
		}
		result = "";
	}
	private static void testProcess() {
		for(int i = 0 ; i<N; i++) {
			cnt = 1;
			for(int j = 0 ; j <N; j++) {
				if(j!=i) {
					if(list[j].height > list[i].height && list[j].weight > list[i].weight) {
						cnt++;
					}
				}
			}
			result += cnt + " ";
		}
	}
	private static void testOutput() {
		System.out.println(result);
	}
}
