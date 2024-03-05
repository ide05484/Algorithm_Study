package B4153;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int A, B, C, Max;
    static boolean result;
    public static void main(String[] args) {
        test();
    }
    private static void test() {
        testInput();
        while(A!=0 && B!=0 && C!=0) {
            testProcess();
            testOutput();
            testInput();
        }
    }
    private static void testInput() {
        A= sc.nextInt();
        B= sc.nextInt();
        Max = Math.max(A, B);
        C= sc.nextInt();
        Max = Math.max(Max, C);
    }
    private static void testProcess() {
        if(Max==A) {
            result = (Max*Max)== (B*B) + (C*C);
        } else if(Max==B) {
            result = (Max*Max)== (A*A) + (C*C);
        } else {
            result = (Max*Max)== (A*A) + (B*B);
        }
    }
    private static void testOutput() {
        if(result) {
            System.out.println("right");
        } else {
            System.out.println("wrong");
        }
    }
}
