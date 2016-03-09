# -*- coding: utf-8 -*-

# Python 的快速排序
def quick_sort(nums):
    if len(nums) <= 1:
        return nums
    else:
        pivot = nums[0]
        return quick_sort([x for x in nums[1:] if x < pivot]) + \
               [pivot] + quick_sort([x for x in nums[1:] if x >= pivot])


if __name__ == "__main__":
    print quick_sort([1, 2, 4, 5, 1, 24, 12, 45, 6, 47, 12])
