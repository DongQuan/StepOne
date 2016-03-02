# -*- coding: utf-8 -*-

"""
用位运算实现两个整数min， max
"""


def min_(a, b):
    a -= b
    a &= a >> 31
    return a + b


def max_(a, b):
    a -= b
    a &= ~a >> 31
    return a + b
print min_(1, 2)
print max_(1, 3)
