---
tags:
  - 算法
  - 栈
---

# 剑指 Offer 30. 包含min函数的栈

题目地址: [剑指 Offer 30. 包含min函数的栈 - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

## 题目描述

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

**示例:**

>  MinStack minStack = new MinStack();
>
> minStack.push(-2);
>
> minStack.push(0);
>
> minStack.push(-3);
>
> minStack.min();   --> 返回 -3.
>
> minStack.pop();
>
> minStack.top();      --> 返回 0.
>
> minStack.min();   --> 返回 -2.


## 解题思路

准备两个栈实现，一个栈放正常数据，另外一个栈存放最小数（push的时候和栈顶的数据进行比较即可 ）

### 代码

```java
package offer;

import java.util.Stack;
public class Code30 {

    class MinStack {
        //存放数据
        Stack<Integer> stack;
        //存放最小数
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                int min = minStack.peek() > x ? x : minStack.peek();
                minStack.push(min);
            }
        }

        public void pop() {
		//stack和minStack大小一致
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
```