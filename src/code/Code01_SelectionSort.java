package code;

import java.util.Arrays;

/**
 * @author wmx
 * @version 1.0
 * @ClassName Code01_SelectionSort
 * @Description 选择排序
 * 0 ~ N-1  找到最小值，在哪，放到0位置上
 * 1 ~ N-1  找到最小值，在哪，放到1 位置上
 * 2 ~ N-1  找到最小值，在哪，放到2 位置上
 * @date 2021/10/11 17:25
 *
 */
public class Code01_SelectionSort {
    public static void selectionSort(int[] arr) {
        //当数组为空，或者数组长度为1时直接返回
        if (arr == null || arr.length < 2) {
            return;
        }
        //对满足条件的数组进行排序
        // 0 ~ N-1  找到最小值，在哪，放到0位置上
        // 1 ~ N-1  找到最小值，在哪，放到1 位置上
        //  2 ~ N-1  找到最小值，在哪，放到2 位置上
        for (int i = 0; i < arr.length - 1; i++) {
            //设置保存i~ N-1的最小值的下标
            //在下下面的逻辑中保证了前i个数是有序的
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 0 ~ N-1  找到最小值，在哪，放到0位置上
                // 1 ~ N-1  找到最小值，在哪，放到1 位置上
                //  2 ~ N-1  找到最小值，在哪，放到2 位置上
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //以下为对数器测试代码
    //构建对数器
    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    //JDK自带的排序进行来判定数组是否排序成功
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static void main(String[] args) {
        int testTime = 10000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                //打印出出错的数据
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "正确" : "错误");

    }
}
