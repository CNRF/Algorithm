---
tags:
  - 算法
  - 链表
---

# 剑指 Offer 24. 反转链表

题目地址: [剑指 Offer 24. 反转链表 - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

## 题目描述

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

**示例:**

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

## 解题思路

利用辅助节点，先将1的next节点保存后，将1节点的next节点指向空节点

### 代码

```java
package offer;

public class Code24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
				//临时存放当前节点的下一个节点数据
        ListNode next;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

```