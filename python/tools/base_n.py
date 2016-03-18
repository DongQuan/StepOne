#!/usr/bin/python
# -*- coding: utf-8 -*-
"""
目的： 给出一个等式， 求出该等式复合的进制
Usage: python base_n.py
请输入等式： 567*456=150216
"""


def main():
    s = raw_input("请输入等式：")

    s_num_1 = s.split("*")[0]
    s_num_2 = s.split("*")[1].split("=")[0]
    s_num_3 = s.split("*")[1].split("=")[1]

    min_jinzhi = find_max_num(s)

    for i in xrange(min_jinzhi, 37):
        if int(s_num_1, i) * int(s_num_2, i) == int(s_num_3, i):
            print "进制数是：" + str(i)


def find_max_num(s):
    temp = 0
    for i in s:
        print i, "i"
        print i is "", "i is ''"
        print len(i), "len(i)"
        print i is " ", "i is ' '"
        if i != "*" and i != "=" and i != " ":
            if int(i) > temp:
                temp = int(i)
    return temp + 1


if __name__ == "__main__":
    main()
