package jxuan95.Book;

import java.util.ArrayList;

/**
 * Created by jxuan on 16-4-16.
 * 合并区间
 */
public class part6_8 {

    public static void main(String[] args) {

        ArrayList<Interval> intervals = new ArrayList<>();
        //四个测试数据
        Interval interval1 = new Interval(1, 5);
        Interval interval2 = new Interval(6, 10);
        Interval interval3 = new Interval(4, 6);
        Interval interval4 = new Interval(15, 20);

        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);

        System.out.println(merge(intervals));

    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();

        //从小到大排序
        int temp;
        for (int i = 1; i < intervals.size(); i++) {
            temp = intervals.get(i).start;
            Interval it = intervals.get(i);
            int j = i - 1;
            for (; j >= 0 && temp < intervals.get(j).start; j--) {
                intervals.set(j + 1, intervals.get(j));
            }
            intervals.set(j + 1, it);
        }

        int i = 0;
        while (i < intervals.size()) {
            Interval current = intervals.get(i);//遍历intervals中的每个interval
            if (res.isEmpty()) {
                res.add(current);
            } else {
                Interval last = res.get(res.size() - 1);//获取结果集中的最后一个区间
                if (last.end >= current.start) {
                    last.end = Math.max(last.end, current.end);//如果res中最后一个区
                    // 间的end比intervals中那个end大，那么就更新res中的最后一个区间的范围
                    //把该interval合并到res中
                } else {
                    res.add(current);//说明current和res中的没有并集，就直接加入结果集
                }
            }
            i++;
        }
        return res;
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
