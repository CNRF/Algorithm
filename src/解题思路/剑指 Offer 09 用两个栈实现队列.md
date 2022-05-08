---
tags:
  - 算法
  - 栈
---

# 剑指 Offer 09. 用两个栈实现队列

题目地址:[剑指 Offer 09. 用两个栈实现队列 - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

## 题目描述

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

**示例 1：**

> 输入：
>
> ["CQueue","appendTail","deleteHead","deleteHead"]
>
> [   [[],[3],[],[]  ]
>
> 输出：[null,null,3,-1]

**示例 2：**

> 输入：
>
> ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
>
> [ [[],[],[5],[2],[],[]  ]
>
> 输出：[null,-1,null,null,5,2]

## 解题思路

准备两个队列，一个队列存放每次新增的数据，一个队列只存放删除的数据，当需要删除数据的时候从队列中弹出一个数据删除。

当有删除操作直接去删除队列获取，如果删除队列为空，则将新增队列的数全部导入到删除队列

> 此处是只需要返回删除的数，不需要返回队列，因此不需要每次都将两个队列来回导数


### 代码

```java
package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Code09 {

    class CQueue {
        //新增栈
        Deque<Integer> stack;
        //删除栈
        Deque<Integer> stack2;
        //初始化
        public CQueue() {
            stack= new LinkedList<>();
            stack2= new LinkedList<>();
        }
        //在尾部新增元素
        public void appendTail(int value) {
            //在删除的时候判断，新增只在新增队列，
            // 只有删除队列没有数才会到新增队列获取新的数
            stack.push(value);
        }
        //在头部删除元素
        public int deleteHead() {
            //当第二个栈为空的时候
            if (stack2.isEmpty()) {
                while (!stack.isEmpty()){
                    stack2.push(stack.pop());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            }else {
                Integer pop = stack2.pop();
                return pop;
            }
        }
    }
}
```