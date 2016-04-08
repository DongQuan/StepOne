import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jxuan on 16-4-8.
 * 京东算法1
 */
public class Weipin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();//委托数
            int s = in.nextInt();//最抢手的清单数
            int[] B = new int[1000];//买入数据
            int[] S = new int[1000];//卖出数据
            while (n > 0) {
                String ss = in.next();
                System.out.println(ss);
                if (ss.equals("B")) {
//                    System.out.println("B");
                    int bt = in.nextInt();
                    int bhot = in.nextInt();
                    B[bt] += bhot;
                } else if (ss.equals("S")) {
//                    System.out.println("S");
                    int st = in.nextInt();
                    int shot = in.nextInt();
                    S[st] += shot;
                }
                n--;
            }
            System.out.println(Arrays.toString(S));
        }
    }
}
