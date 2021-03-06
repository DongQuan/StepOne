package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-4-14.
 * 在每年的校赛里，所有进入决赛的同学都会获得一件很漂亮的t-shirt。
 * 但是每当我们的工作人员把上百件的衣服从商店运回到赛场的时候，却是非常累的！
 * 所以现在他们想要寻找最短的从商店到赛场的路线，你可以帮助他们吗？
 * 输入包括多组数据。每组数据第一行是两个整数N、M（N<=100，M<=10000），
 * N表示成都的大街上有几个路口，标号为1的路口是商店所在地，标号为N的路口是赛场所在地，
 * M则表示在成都有几条路。N=M=0表示输入结束。接下来M行，每行包括3个整数A，B，C（1<=A,B<=N,1<=C<=1000）,
 * 表示在路口A与路口B之间有一条路，我们的工作人员需要C分钟的时间走过这条路。
 * 输入保证至少存在1条商店到赛场的路线。
 * 对于每组输入，输出一行，表示工作人员从商店走到赛场的最短时间
 */
public class HDU2544 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();//表示有N个路口
        int M = in.nextInt();//表示有M条路

        while (M > 0) {
            int a = in.nextInt();//路口a
            int b = in.nextInt();//路口b
            int c = in.nextInt();//时间c

            if ((a == 1 && b == N) || (a == N && b == 1)) {
                System.out.println(c);
                continue;
            }
            M--;
        }

    }
}
