package code;

import java.util.Arrays;

/**
 * @author wmx
 * @version 1.0
 * @className Code05_BSNearLeft
 * @description 二分查找在有序数组中大于某个数的最左的位置
 * @date 2021/10/19 15:56
 */
public class Code05_BSNearLeft {
    /**
     * 在arr数组中查找满足 >=value 的最左位置
     *
     * @param arr   数组
     * @param value 查找的数
     * @return {@link int}
     * @author wmx
     * @date 2021/10/19 16:59
     **/
    public static int nearestLeftIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        //用来记录最左侧的数下标变量
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }


    /**
     * 遍历数组确定是最左边接近num的数
     *
     * @param arr 数组
     * @param num 需要查找的数
     * @return {@link boolean}
     * @author wmx
     * @date 2021/10/19 16:34
     **/
    //for test
    public static int findIndex(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
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

    //for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (findIndex(arr, value) != nearestLeftIndex(arr, value)) {
                ArrayUtils.printArray(arr);
                System.out.println(value);
                System.out.println(findIndex(arr, value));
                System.out.println(nearestLeftIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "正确" : "错误");
    }
}
