package practice.code;

import code.ArrayUtils;

/**
 * 选择排序
 *
 * @author mingxing.wang
 * @date 2022/5/12 10:43
 */
public class Code01_SelectionSort {
    public static void selectionSort(int[] arr) {
        //code
    }

    //for test
    public static void main(String[] args) {
        int testTime = 10000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrayUtils.generateRandomArray(maxSize, maxValue);
            int[] arr1 = ArrayUtils.copyArray(arr);
            int[] arr2 = ArrayUtils.copyArray(arr);
            selectionSort(arr1);
            ArrayUtils.comparator(arr2);
            if (!ArrayUtils.isEqual(arr1, arr2)) {
                //打印出出错的数据
                succeed = false;
                ArrayUtils.printArray(arr);
                break;
            }
        }
        System.out.println(succeed ? "正确" : "错误");

    }
}
