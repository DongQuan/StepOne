# -*- coding: utf-8 -*-
"""
计算组合数： m, n, m<=n<=25
Cnm = n! / (m!*(n-m)!)
eg： n=25, m=12, ans == 5200300
"""


def main(n, m):
    ans = factorial(n) / (factorial(m) * factorial(n - m))
    print ans


def main_di(n, m):
    ans = factorial_di(n) / (factorial_di(m) * factorial_di(n - m))
    print ans


# a factorial function for n!
def factorial(num):
    x = 1
    for i in range(1, num + 1):
        x *= i
    return x


# 递归阶乘
def factorial_di(num):
    if num <= 1:
        return 1
    else:
        return factorial_di(num - 1) * num


main(25, 12)
main_di(25, 12)
