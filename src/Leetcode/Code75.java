package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code75
 * @description https://leetcode-cn.com/problems/sort-colors/
 * @date 2022/1/18 10:07
 */
public class Code75 {
    public static void sortColors(int[] nums) {
        quickSort1(nums);
    }

    private static void quickSort1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        process(nums, 0, nums.length - 1);
    }

    public static void process(int[] nums, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = partition(nums, L, R);
        process(nums, L, M - 1);
        process(nums, M + 1, R);
    }

    /**
     * @param arr 需要排序的数组
     * @param L   需要排序的数组的节点左边界
     * @param R   需要排序的数组的节点右边界
     * @return
     */
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
