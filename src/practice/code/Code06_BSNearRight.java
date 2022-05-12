package practice.code;

import code.ArrayUtils;

import java.util.Arrays;

/**
 * @author wmx
 * @version 1.0
 * @className Code06_BSNearRight
 * @description 二分查找在有序数组中大于某个数的最右的位置
 * @date 2021/10/19 16:07
 */
public class Code06_BSNearRight {
    public static int nearestRightIndex(int[] arr, int value) {
        return 0;
    }

    /**
     * 遍历数组确定是最右边接近num的数
     *
     * @param arr 数组
     * @param num 需要查找的数
     * @return {@link boolean}
     * @author wmx
     * @date 2021/10/19 16:34
     **/
    //for test
    public static int findIndex(int[] arr, int num) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= num) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 生成一个数组长度在1 ~ maxSize，指定数据范围在(-maxValue+1,+maxValue]的数组
     *
     * @param maxSize  生成数组的长度
     * @param maxValue 生成数组的中的元素最大值
     * @return {@link int[]}
     * @author wmx
     * @date 2021/10/19 16:45
     **/
    //for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        //是生成的数组长度在0~maxSize之间
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            //(int)(Math.random() * N)    [0, N-1]
            //保证生成的元素在(-maxValue,+maxValue]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (findIndex(arr, value) != nearestRightIndex(arr, value)) {
                ArrayUtils.printArray(arr);
                System.out.println(value);
                System.out.println(findIndex(arr, value));
                System.out.println(nearestRightIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "正确" : "错误");
    }
}
