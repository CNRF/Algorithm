package practice.code;

import code.ArrayUtils;

/**
 * @author wmx
 * @version 1.0
 * @className Code19_GetMax
 * @description 找数组指定下标范围的最大值
 * @date 2021/11/30 15:20
 */
public class Code19_GetMax {
    //获取数组中最大数
    public static int getMax(int[] arr) {
        return 0;
    }

    //获取数组中指定范围的最大数


    //for test
    public static int getMaxArr(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int a = arr[0];
        for (int i : arr) {
            if (a < i) {
                a = i;
            }
        }
        return a;
    }

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
        int testTimes = 1000000;
        int maxValue = 100;
        int maxSize = 1000;
        boolean success = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            if (getMax(arr) != getMaxArr(arr)) {
                success = false;
                ArrayUtils.printArray(arr);
                break;
            }
        }
        System.out.println(success ? "正确" : "错误");
    }
}
