---
tags:
  - 算法
---

## 剑指 Offer 05. 替换空格

**题目地址：** [剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

## 题目

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

**示例 1：**

```
输入：s = "We are happy."

输出："We%20are%20happy."
```



## 解题思路

1. 直接用java 的replaceAll方法（这个算吗？？）
2. String拼接中间麻烦，直接同stringBuffer进行拼接

### 代码

```
package offer;

public class Code05 {
    public static  String replaceSpace(String s) {
        // String s2 = s1.replaceAll("\\s", "%20");
        StringBuffer result = new StringBuffer();
        if (s == null||s.length()==0) {
            return result.toString();
        }
        for (char c : s.toCharArray()) {
            if (c==' '){
                result.append("%20");
            }else {
                result.append(c);
            }
        }
        return  result.toString();
    }

    public static void main(String[] args) {
        String s1="We are happy.";
        String s = replaceSpace("We are happy.");
        System.out.println(s);


        System.out.println(s2);
    }
}

```

