package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code167
 * @description https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @date 2022/1/2 11:43
 */
public class Code167 {
    public static int[] twoSum(int[] numbers, int target) {
        int[] results = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            int result = target - numbers[i];
            //此处可以考虑换成二分查找而非遍历
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == result) {
                    results[0] = i + 1;
                    results[1] = j + 1;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] numbers = {-1, 0};
        int target = -1;
        int[] ints = twoSum(numbers, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
