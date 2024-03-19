
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, digit, result;
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
        int tmp = N;
        while(tmp>0) {
            tmp/=10;
            digit++;
        }
    }
    private static void testProcess() {
        for(int i = Math.max(1, N-digit*9); i<N; i++) {
            int tmp1 = i;
            int tmp2 = i;
            while(tmp1>0) {
                tmp2+=tmp1%10;
                tmp1/=10;
            }
            if(tmp2==N) {
                result=i;
                break;
            }
        }
    }
    private static void testOutput() {
        System.out.println(result);
    }
}
