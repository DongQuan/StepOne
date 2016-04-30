package jxuan95;

import java.util.Scanner;

/**
 * Created by jxuan on 16-4-27.
 * 今日头条算法第三题
 */
public class TodayNews3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();//n首歌
            int s = in.nextInt();//每首歌都是s秒
            int L = in.nextInt();//光盘长度
            int cdcount;//CD的数量

//            int musicNum = L / (s + 1);//每张光盘能放的歌曲数量
//            while (musicNum % 13 == 0) {
//                musicNum--;
//            }
//
//            if (n % musicNum == 0) {
//                cdcount = n / musicNum;
//            } else {
//                cdcount = n / musicNum + 1;
//            }
//            System.out.println(cdcount);

            int sumt = n * (s + 1);

        }
    }
}
