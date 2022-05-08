---
tags:
  - 算法
---

## 剑指 Offer 35. 复杂链表的复制

**原题地址：** [剑指 Offer 35. 复杂链表的复制 - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)

## 题目

请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

**示例1**

![image-20220105140945351](https://gitee.com/CNRF/image/raw/master/image-20220105140945351.png)

```
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
```

**示例2**

![image-20220105141041607](https://gitee.com/CNRF/image/raw/master/image-20220105141041607.png)

```
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
```

## 解题思路

利用哈希表的查询特点，考虑构建 **原链表节点** 和 **新链表对应节点** 的键值对映射关系，再遍历构建新链表各节点的 `next` 和 `random` 引用指向即可。

**算法流程：**

1. 若头节点 head 为空节点，直接返回 `null`；

2. **初始化**： 哈希表 dic ， 节点 cur 指向头节点；
3. **复制链表**：
   1. 建立新节点，并向 dic 添加键值对 (原 cur 节点, 新 cur 节点） ；
   2. cur 遍历至原链表下一节点；
4. **构建新链表的引用指向**：
   1. 构建新节点的 next 和 random 引用指向；
   2. cur 遍历至原链表下一节点；
5. **返回值**： 新链表的头节点 `dic[cur]` ；

![1604747285-bhLYzn-Picture13](https://gitee.com/CNRF/image/raw/master/1604747285-bhLYzn-Picture13.png)

### 代码

```java
package offer;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wmx
 * @version 1.0
 * @className Code35
 * @description https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @date 2022/1/5 14:25
 */
public class Code35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur=head;
        HashMap<Node, Node> map = new HashMap<>();
        //将原来链表的数值赋值到map中
        while (cur!=null){
            map.put(cur, new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        //构建新链表
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
}

```

