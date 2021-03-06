package Leetcode;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author wmx
 * @version 1.0
 * @className Code2034
 * @description
 * @date 2022/1/23 11:28
 */
public class Code2034 {
    HashMap<Integer, Integer> map;
    TreeMap<Integer, Integer> ts;
    int cur = 0;

    public Code2034() {
        map = new HashMap<>();
        ts = new TreeMap<>();
    }

    public static void main(String[] args) {
        Code2034 code2034 = new Code2034();
        code2034.update(1, 10);
        code2034.update(2, 5);
        int current = code2034.current();
        code2034.update(1, 3);
        int maximum = code2034.maximum();
        code2034.update(4, 2);
        int minimum = code2034.minimum();
    }

    public void update(int timestamp, int price) {
        cur = Math.max(timestamp, cur);
        if (map.containsKey(timestamp)) {
            int old = map.get(timestamp);
            int cnt = ts.get(old);
            if (cnt == 1) ts.remove(old);
            else ts.put(old, cnt - 1);
        }
        map.put(timestamp, price);
        ts.put(price, ts.getOrDefault(price, 0) + 1);

    }

    public int current() {
        return map.get(cur);
    }

    public int maximum() {
        return ts.lastKey();
    }

    public int minimum() {
        return ts.firstKey();
    }
}
