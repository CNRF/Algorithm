package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wmx
 * @version 1.0
 * @className Code46
 * @description
 * @date 2022/1/10 11:06
 */
public class Code46 {
    //已经使用的元素
    private static final LinkedList<Integer> usedList = new LinkedList<>();
    //返回的全排列
    private static final List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return result;
        }
        getCombine(usedList, nums);
        return result;
    }

    public static void getCombine(LinkedList<Integer> usedList, int[] nums) {
        if (usedList.size() == nums.length) {
            result.add(new ArrayList<>(usedList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (usedList.contains(nums[i])) {
                continue;
            }
            usedList.add(nums[i]);
            getCombine(usedList, nums);
            usedList.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> integers : permute) {
            System.out.print("[");
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println("]");
        }
    }
}
