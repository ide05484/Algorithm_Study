package B11651_좌표정렬하기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class xy implements Comparable<xy>{
	int x;
	int y;
	public xy(int x, int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public int compareTo(xy o) {
		if(o.y==this.y) {
			return this.x-o.x;
		}
		return this.y-o.y;
	}
	
}


public class 이창현_좌표정렬하기2_11651 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static xy[] arr;
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
        arr=new xy[N];
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            xy tmp = new xy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            arr[i]=tmp;
        }
    }
    private static void testProcess() {
    	Arrays.sort(arr);
        for(int i = 0; i<arr.length; i++) {
            sb.append(arr[i].x + " " + arr[i].y + "\n");
        }
    }
    private static void testOutput() {
        System.out.println(sb.toString());
    }

}