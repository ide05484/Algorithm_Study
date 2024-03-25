package B1181_단어정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Str implements Comparable<Str>{
	String str;
	public Str(String str) {
		this.str= str;
	}
	@Override
	public int compareTo(Str o) {
		if(o.str.length()==this.str.length()) {
			for(int i = 0; i<this.str.length(); i++) {
				if(this.str.charAt(i)!=o.str.charAt(i)) {
					return this.str.charAt(i)-o.str.charAt(i);
				}
			}
		}
		return this.str.length()-o.str.length();
	}
}


public class 이창현_단어정렬_1181 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Str[] arr;
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
        arr=new Str[N];
        for(int i = 0; i<N; i++) {
            arr[i] = new Str(br.readLine());
        }
    }
    private static void testProcess() {
    	Arrays.sort(arr);
    	sb.append(arr[0].str+"\n");
        for(int i = 1; i<arr.length; i++) {
        	if(!(arr[i].str.equals(arr[i-1].str))) {        		
        		sb.append(arr[i].str+"\n");
        	}
        }
    }
    private static void testOutput() {
        System.out.println(sb.toString());
    }

}
