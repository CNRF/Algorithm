---
tags:
  - 算法
  - 链表
---

# 剑指 Offer 06. 从尾到头打印链表

题目地址: [剑指 Offer 06. 从尾到头打印链表 - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)
## 题目描述

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

**示例 1：**

> 输入：head = [1,3,2]
>
> 输出：[2,3,1]

## 解题思路

利用栈的后进先出的特点，将链表中的元素放入栈之中之后再弹出栈数据即可


### 代码

```java
package offer;

import java.util.Stack;

public class Code06 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> result = new Stack<>();
        ListNode temp=head;
        while (temp!=null){
            result.push(temp);
            temp=temp.next;
        }
        int size=result.size();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i]=result.pop().val;
        }
        return ints;
    }
}
```