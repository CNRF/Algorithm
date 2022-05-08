---
tags:
  - 算法
  - 二分查找
---

## 剑指 Offer 03. 数组中重复的数字

**原文地址：**[剑指 Offer 03. 数组中重复的数字 - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

## 题目

找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

**示例 1：**

```
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
```

## 解题思路

1. 使用辅助缓存hashSet，hashset存在直接返回即可

   ```java
   package offer;
   
   import java.util.HashSet;
   
   public class Code03 {
       public int findRepeatNumber(int[] nums) {
           HashSet<Integer> integers = new HashSet<>();
           for (int num : nums) {
               if (integers.contains(num)) {
                   return num;
               }
               integers.add(num);
           }
           return -1;
       }
   }
   
   ```

   

2. 根据题意可知  将对应数值的数放到对应下标中，在数值为i的数在num[i]会出现多次

3. ```java
   package offer;
   
   import java.util.HashSet;
   public class Code03 {
   
       public int findRepeatNumber2(int[] nums) {
       //根据条件  在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内
           // 可以判定每一个数都在nums中有下标相同的位置
           int i=0;
           while (i<nums.length){
               if (nums[i] == i) {
                   i++;
                   continue;
               }
                   if (nums[nums[i]] == nums[i]) {
                       return nums[i];
                   }
                   int temp=nums[i];
                   nums[i]=nums[temp];
                   nums[temp]=temp;
               }
           return -1;
       }
   }
   
   ```

   