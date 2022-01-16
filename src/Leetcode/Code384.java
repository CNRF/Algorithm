package Leetcode;

import java.util.Random;

/**
 * @author wmx
 * @version 1.0
 * @className Code384
 * @description https://leetcode-cn.com/problems/shuffle-an-array/solution/
 * @date 2022/1/16 11:38
 */
public class Code384 {
    int[] nums;
    int length;
    Random random = new Random();

    public Code384(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] res = nums.clone();
        for (int i = 0; i < length; i++) {
            swap(res, i, i + random.nextInt(length - i));
        }
        return res;
    }

    private void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
