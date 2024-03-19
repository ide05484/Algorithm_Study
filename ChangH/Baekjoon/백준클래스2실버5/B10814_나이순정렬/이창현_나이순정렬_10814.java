package B10814_나이순정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class People implements Comparable<People>{
	static int no;
	int idx;
	int age;
	String name;
	public People(int age, String name) {
		this.idx= ++no;
		this.age= age;
		this.name= name;
	}
	@Override
	public int compareTo(People o) {
		if(o.age==this.age) {
			return this.idx-o.idx;
		}
		return this.age-o.age;
	}
	@Override
	public String toString() {
		return age + " " + name +"\n";
	}
	
	
}


public class 이창현_나이순정렬_10814 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static People[] arr;
    static int N;
    public static void main(String[] args) throws Exception {
        test();
    }
    private static void test() throws Exception {
        testInput();
        testProcess();
        testOutput();
    }
    private static void testInput() throws Exception {
        N= Integer.parseInt(br.readLine());
        arr=new People[N];
        for(int i = 0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
            arr[i] = new People(Integer.parseInt(st.nextToken()), st.nextToken());
        }
    }
    private static void testProcess() {
    	Arrays.sort(arr);
        for(int i = 0; i<arr.length; i++) {
        	sb.append(arr[i]);
        }
    }
    private static void testOutput() {
        System.out.println(sb.toString());
    }

}
