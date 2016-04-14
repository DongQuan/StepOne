package jxuan95.SaiCode;

import java.util.Scanner;

/**
 * Created by jxuan on 16-4-1.
 * 某省调查城镇交通状况，得到现有城镇道路统计表，表中列出了每条道路直接连通的城镇。
 * 省政府“畅通工程”的目标是使全省任何两个城镇间都可以实现交通（但不一定有直接的道路相连，
 * 只要互相间接通过道路可达即可）。问最少还需要建设多少条道路？
 * 测试输入包含若干测试用例。每个测试用例的第1行给出两个正整数，分别是城镇数目N ( < 1000 )和道路数目M；
 * 随后的M行对应M条道路，每行给出一对正整数，分别是该条道路直接连通的两个城镇的编号。为简单起见，城镇从1到N编号。
 注意:两个城市之间可以有多条道路相通,也就是说
 3 3
 1 2
 1 2
 2 1
 这种输入也是合法的
 当N为0时，输入结束，该用例不被处理。

 */
public class HDU1232 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            if (N == 0) {
                break;
            }
            int M = in.nextInt();
            int[] pro = new int[N + 1];
            for (int i = 1; i < pro.length; i++) {
                pro[i] = i;
            }
            while (M > 0) {
                int a = in.nextInt();
                int b = in.nextInt();
                combain(a, b, pro);

                M--;
            }
            int count = -1;//因为最终的跟节点的pro一定是它本身，所以需要减掉一个次数
            for (int i = 1; i < pro.length; i++) {
                if (pro[i] == i) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void combain(int x, int y, int[] pro) {
        int a, b;
        a = find(pro, x);
        b = find(pro, y);
        if (a != b) {
            pro[a] = b;
        }
    }

    public static int find(int[] pro, int x) {
        if (pro[x] != x) {
            pro[x] = find(pro, pro[x]);
        }
        return pro[x];
    }

}
