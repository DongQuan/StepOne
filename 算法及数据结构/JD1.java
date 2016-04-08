import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jxuan on 16-4-8.
 * 京东算法1
 */
public class JD1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();//委托数
            int s = in.nextInt();//最抢手的清单数
            int[] B = new int[1000];//买入数据
            int[] S = new int[1000];//卖出数据
            while (n > 0) {
                String ss = in.next();
//                System.out.println(ss);
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

            int countB = 0;//有多少个非零数据
            int countS = 0;
            for (int i = 0; i < B.length; i++) {
                if (B[i] != 0) {
                    countB++;
                }
            }
            for (int i = 0; i < S.length; i++) {
                if (S[i] != 0) {
                    countS++;
                }
            }

            int[] resultB = new int[countB];//存结果，没有排序
            int[] indexB = new int[countB];//存索引
            int[] resultS = new int[countS];
            int[] indexS = new int[countS];//存索引
            for (int j = 0; j < resultB.length; j++) {
                for (int i = 0; i < B.length; i++) {
                    if (B[i] != 0) {
                        indexB[j] = i;
                        resultB[j] = B[i];
                        j++;
                    }
                }
            }
            for (int j = 0; j < resultS.length; j++) {
                for (int i = 0; i < S.length; i++) {
                    if (S[i] != 0) {
                        indexS[j] = i;
                        resultS[j] = S[i];
                        j++;
                    }
                }
            }

            //排序
            int temp, tempindex;
            for (int i = 0; i < resultB.length; i++) {
                temp = resultB[i];
                tempindex = indexB[i];
                int j = i + 1;
                for (; j < resultB.length; j++) {
                    if (resultB[j] > resultB[i]) {
                        resultB[i] = resultB[j];
                        resultB[j] = temp;
                        indexB[i] = indexB[j];
                        indexB[j] = tempindex;
                        temp = resultB[i];
                        tempindex = indexB[i];
                    }
                }
            }

            int tempS, tempindexS;
            for (int i = 0; i < resultS.length; i++) {
                tempS = resultS[i];
                tempindexS = indexS[i];
                int j = i + 1;
                for (; j < resultS.length; j++) {
                    if (resultS[j] < resultS[i]) {
                        resultS[i] = resultS[j];
                        resultS[j] = tempS;
                        indexS[i] = indexS[j];
                        indexS[j] = tempindexS;
                        tempS = resultS[i];
                        tempindexS = indexS[i];
                    }
                }
            }

            for (int i = 0; i < resultS.length; i++) {
                System.out.println("S" + " " + indexS[i] + " " + resultS[i]);
            }
            for (int i = 0; i < resultS.length; i++) {
                System.out.println("B" + " " + indexB[i] + " " + resultB[i]);
            }
        }
    }
}
