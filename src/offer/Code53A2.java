package offer;

/**
 * @author wmx
 * @version 1.0
 * @className Code53A2
 * @description https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 * @date 2022/1/7 11:35
 */
public class Code53A2 {
    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left - 1) >> 1);
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(missingNumber(arr));
    }
}
