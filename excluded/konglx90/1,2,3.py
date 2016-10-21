# -*- coding: utf-8 -*-
"""
     * 习题2-6：排列
     * 用1,2,3……,9组成3个三位数abc,def和ghi,每个数字恰好使用一次,要求abc:def:ghi=1:2:3.输出所有解。
     * P35
"""
for i in xrange(123, 330):
    num1, num2, num3 = i, i*2, i*3
    if "0" in str(num1) or "0" in str(num2) or "0" in str(num3): continue
    if len(set(str(num1) + str(num2) + str(num3))) == 9: print num1, num2, num3