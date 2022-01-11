package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmx
 * @version 1.0
 * @className Code77
 * @description https://leetcode-cn.com/problems/combinations/
 * @date 2022/1/10 9:32
 */
public class Code77 {
    private static final List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        getCombine(n, k, 1, new ArrayList<>());
        return ans;
    }

    private static void getCombine(int n, int k, int start, List<Integer> list) {
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            getCombine(n, k - 1, i + 1, list);
            //此处删除是为了保证下次遍历，之前的组合前面保留
            //如这一次是[1,2],下次是[1,3],remove之后只保留[1],3是下次获取到的
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        for (List<Integer> integers : combine) {
            System.out.print("[");
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println("]");
        }
    }
}
