# -*- coding: utf-8 -*-

"""
折半查找， 对有序列表
"""


def find_half(l=[1, 2, 3, 45, 122, 158, 200, 219, 300, 1555, 2000, 2100, 2330], find_num=45):
    """
    非递归版本
    :param l: [1,2,3,45,122,158,200,219,300,1555,2000,2100,2330]
    :param find_num: 45
    :return: False or index of find_num
    """
    left, middle, right = 0, len(l) / 2, len(l) - 1
    while left-right > 1:
        if l[middle] == find_num:
            return middle
        # elif right - left == 1:  # 没有该数时的终止条件
        #     return False
        elif find_num > l[middle]:
            left, middle, right = middle, (middle + 1 + right) / 2, right
        else:
            left, middle, right = left, (middle - 1 + left) / 2, middle
    # 把left-right==1单独拿出来处理, important
    if find_num == l[left]:
        return left
    elif find_num == l[right]:
        return right
    else:
        return False


if __name__ == "__main__":
    # print find_half([1, 2, 3, 45, 122, 158, 200, 219, 300, 1555, 2000, 2100, 2330], 45)
    # print find_half(find_num=122)
    # print find_half(find_num=219)
    # for i in [1, 2, 3, 45, 122, 158, 200, 219, 300, 1555, 2000, 2100, 2330]:
    #     print find_half(find_num=i)
    # print find_half(find_num=12)
    test = []
    test = [find_half(find_num=i) for i in xrange(3000) if
            i not in [1, 2, 3, 45, 122, 158, 200, 219, 300, 1555, 2000, 2100, 2330]]
    print len(test)
    print "need 3000-13 = 2987"
