package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wmx
 * @version 1.0
 * @className Code2013
 * @description https://leetcode-cn.com/problems/detect-squares/
 * @date 2022/1/26 9:27
 */
public class Code2013 {
    //使用hashmap做缓存，外面存放x轴相同数据，里面map存放y轴相同数据
    HashMap<Integer, Map<Integer, Integer>> row2Col = new HashMap<>();

    public Code2013() {

    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        Map<Integer, Integer> col2Cnt = row2Col.getOrDefault(x, new HashMap<>());
        col2Cnt.put(y, col2Cnt.getOrDefault(y, 0) + 1);
        row2Col.put(x, col2Cnt);

    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        int ans = 0;
        Map<Integer, Integer> col2Cnt = row2Col.getOrDefault(x, new HashMap<>());
        for (int ny : col2Cnt.keySet()) {
            if (ny == y) {
                //相同点直接排除
                continue;
            }
            int c1 = col2Cnt.get(ny);
            int len = y - ny;
            int[] nums = new int[]{x + len, x - len};
            for (int nx : nums) {
                Map<Integer, Integer> temp = row2Col.getOrDefault(nx, new HashMap<>());
                int c2 = temp.getOrDefault(y, 0), c3 = temp.getOrDefault(ny, 0);
                ans += c1 * c2 * c3;
            }

        }
        return ans;
    }
}
