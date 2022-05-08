---
tags:
  - 算法
  - 二分查找
---

## 剑指 Offer 53 - I. 在排序数组中查找数字 I

**题目地址：**[剑指 Offer 53 - I. 在排序数组中查找数字 I - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)

## 题目

统计一个数字在排序数组中出现的次数。

## 解题思路

**数组是有序的**，通过二分查找确定元素位置（没有就返回0），有则像左右拓展找元素

### 代码

```java
package offer;

public class Code53A1 {

    public static int binarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums[binarySearchRight(nums, target)] != target || nums[binarySearchLeft(nums, target)] != target) {
            return 0;
        }
        return binarySearchRight(nums, target) - binarySearchLeft(nums, target) + 1;
    }

    //二分查找元素第一次出现的位置
    public static int binarySearchLeft(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //数据不存在的情况返回-1
        if (nums[right] != target) {
            return 0;
        }
        return right;
    }

    //二分查找元素最后一次出现的位置
    public static int binarySearchRight(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        //数据不存在的情况返回-1
        if (nums[left] != target) {
            return 0;
        }
        return left;
    }

}

```

