package jxuan95.Book;

import java.util.*;

/**
 * Created by jxuan on 16-4-16.
 * 重叠区间个数
 */
public class part6_6 {
    public static void main(String[] args) {

        //四个测试数据
        Interval interval1 = new Interval(1, 5);
        Interval interval2 = new Interval(10, 15);
        Interval interval3 = new Interval(5, 10);
        Interval interval4 = new Interval(20, 30);

        Interval[] intervals = new Interval[]{interval1, interval2, interval3, interval4};

        Test(intervals);
    }

    public static void Test(Interval[] A) {
        int max = 0, count = 1;
        Point[] points = new Point[A.length * 2];//因为每个区间有两个节点
        for (int i = 0; i < A.length; i++) {
            points[2 * i] = new Point(A[i].start, 0);//0为起点
            points[2 * i + 1] = new Point(A[i].end, 1);//1为终点
        }

        //直接插入排序
        Point temp;
        for (int i = 1; i < points.length; i++) {
            temp = points[i];
            int j = i - 1;
            for (; j >= 0 && temp.value < points[j].value; j--) {
                points[j + 1] = points[j]; //后移一个位置
            }
            points[j + 1] = temp;
        }

        for (int i = 0; i < points.length; i++) {
            if (points[i].type == 0) {
                count++;
                max = Math.max(max, count);
            } else {
                count--;
            }
        }

        System.out.println(max);

    }

    static class Interval {
        int start;//起点
        int end;//止点

        Interval(int a, int b) {
            start = a;
            end = b;
        }
    }

    static class Point {

        int value;//值
        int type;//点的类型，0表示起点，1表示终点

        Point(int v, int t) {
            value = v;
            type = t;
        }
    }
}
