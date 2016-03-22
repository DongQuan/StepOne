package jxuan95.java;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jxuan on 16-3-22.
 * 算法
 */
public class Arithmetic6 {

    public static void main(String[] args) {
        Arithmetic6.Rails();
    }

    /**
     * 某城市一个火车站，n节车厢驶入，判断驶出是否合法；
     * 用栈来实现，先进后出
     * @return 返回是否合法；
     */
    public static String Rails() {

        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int A = 1, B = 1;
        System.out.println("输入火车节数：");
        int n = in.nextInt();//火车节数

        int[] arails = new int[2 * n];

        for (int i = 1; i <= n; i++) {
            arails[i] = in.nextInt();
        }

        boolean ok = true;


        while (B <= n) {

            //A表示按顺序该进入第几节车厢，arails[B]表示用户输入的出栈车厢
            if (A == arails[B]) {
                A++;
                B++;
            } else if (!stack.empty() && stack.peek() == arails[B]) { //如果栈不为空，栈顶的那个元素是即将出栈的元素
                stack.pop();
                B++;
            } else if (A <= n) {
                stack.push(A);
                A++;
            } else {
                ok = false;
                break;
            }
        }

        System.out.println(ok ? "yes" : "no");


        return null;
    }

}
