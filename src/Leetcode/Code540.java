package Leetcode;

/**
 * @author mingxing.wang
 * @version 1.0
 * @className Code
 * @description https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * @date 2022/2/14 14:54
 */
public class Code540 {
    /**
     * 使用异或（1^1=0）直接获取相关数据
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {

        int num=0;
        for (int i : nums) {
            num=num^i;
        }
        return num;
    }
}
