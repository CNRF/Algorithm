package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code04
 * @description https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @date 2022/1/17 10:54
 */
public class Code04 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //求出两个数组的总长度
        int total = nums1.length + nums2.length;
        //如果是奇数，则求出中间两个数的平均数
        if ((total & 1) == 0) {
            int left = find(nums1, 0, nums2, 0, total / 2);
            int right = find(nums1, 0, nums2, 0, total / 2 + 1);
            return (left + right) / 2.0;    //求平均数，注意要除2.0，否则会下取整
        }
        //如果是偶数，则直接返回中位数
        return find(nums1, 0, nums2, 0, total / 2 + 1);
    }

    /**
     * @param nums1 数组1
     * @param i     数组1的起始位置
     * @param nums2 数组2
     * @param j     数组2的起始位置
     * @param k     k为第k小的数
     * @return 两个数组的中位数
     */
    private static int find(int[] nums1, int i, int[] nums2, int j, int k) {
        //为了方便，使nums1的剩余长度小于nums2的剩余长度
        if (nums1.length - i > nums2.length - j) {
            return find(nums2, j, nums1, i, k);
        }
        //如果nums1的起始位置已经与其长度相等，则nums1中的数已经用光了，返回nums2中第K小的数
        if (nums1.length == i) {
            return nums2[j + k - 1];
        }
        //如果k等于1，则相当与求出两个数组中的最小值，直接返回nums1[i], nums2[j]中较小的一个
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        //si表示我们上面所说的A[k / 2]后面的那个数的下标。
        //此处si与nums1的长度取最小值，因为可能会出现i + k / 2 > num1.length的情况
        int si = Math.min(nums1.length, i + k / 2);
        //sj与si表示的含义相同，表示B[k / 2]后面的那个数的下标
        //这里使用sj = j + k - k / 2是为了保证以该点为分界线的数组的前半部分的总长与A数组中前半部分的总长度的和为k。
        //因为如果k是奇数，如果si,sj都使用k/2，则导致总数比k少1
        //例如：k = 5, i = j = 0
        //此时si = 5 / 2 = 2, 如果sj使用j + k / 2, 则sj = 5 / 2 = 2, 2 + 2 = 4 < 5.
        int sj = j + k - k / 2;

        //如果nums1[si - 1] > nums2[sj - 1],对应上面的情况二
        if (nums1[si - 1] > nums2[sj - 1]) {
            //由于去除了从j 到 sj 之间的数，所以原本的第K小的数在新数组中为第k - (sj - j)小的数
            return find(nums1, i, nums2, sj, k - (sj - j));
        }
        //如果nums2[si - 1] <= nums[sj - 1],对应上面的1， 3
        //此处不应该把情况3单独拿出来，因为可能会出现一种边界情况，即i + k / 2 > nums1.length
        //如果按照上面情况3的讨论，我们可以返回nums1[si] 或 nums2[sj]，但是此时因为nums1长度不足了，所以nums[si]并不是两个数组中第k小的数
        else {
            return find(nums1, si, nums2, j, k - (si - i));
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums2 = {4, 5};
        double medianSortedArrays = findMedianSortedArrays(nums, nums2);
        System.out.println(medianSortedArrays);
    }
}
