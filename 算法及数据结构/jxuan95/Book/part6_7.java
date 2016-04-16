package jxuan95.Book;

import java.util.ArrayList;

/**
 * Created by jxuan on 16-4-16.
 * 插入区间
 */
public class part6_7 {

    public static void main(String[] args) {

    }

    public static ArrayList<Interval> insert(Interval[] intervals, Interval newInt) {
        ArrayList<Interval> arrayList = new ArrayList<>();
        if (intervals == null) {
            arrayList.add(newInt);
            System.out.println(arrayList);
            return arrayList;
        }
        int i = 0, n = intervals.length;
        //如果新插入区间的起点大于已存在区间的终点，就把已有区间添加进list
        while (i < n && newInt.start > intervals[i].end) {
            arrayList.add(intervals[i++]);
        }

        while (i < n && newInt.start <= intervals[i].end) {
            //合并重叠区域
            newInt.start = Math.min(newInt.start, intervals[i].start);
            newInt.end = Math.max(newInt.end, intervals[i].end);
            i++;
        }

        arrayList.add(newInt);

        //加上剩余部分
        while (i < n) {
            arrayList.add(intervals[i++]);
        }

        return arrayList;
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
