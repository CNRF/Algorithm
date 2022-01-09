package offer;

/**
 * @author wmx
 * @version 1.0
 * @className Code53A1
 * @description https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @date 2022/1/7 9:32
 */
public class Code53A1 {
    public static int binarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums[binarySearchRight(nums, target)] != target || nums[binarySearchLeft(nums, target)] != target) {
            return 0;
        }
        return binarySearchRight(nums, target) - binarySearchLeft(nums, target) + 1;
    }

    //二分查找元素第一次出现的位置
    public static int binarySearchLeft(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //数据不存在的情况返回-1
        if (nums[right] != target) {
            return 0;
        }
        return right;
    }

    //二分查找元素最后一次出现的位置
    public static int binarySearchRight(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        //数据不存在的情况返回-1
        if (nums[left] != target) {
            return 0;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        int target = 7;
//        binarySearchLeft(arr, target);

//        System.out.println(binarySearch(arr, target));
        System.out.println(binarySearchLeft(arr, target));
        System.out.println(binarySearchRight(arr, target));
    }

    public int search(int[] nums, int target) {
        return 0;
    }
}
