package practice.code;

import code.ArrayUtils;

import java.util.Arrays;

/**
 * @author wmx
 * @version 1.0
 * @className Code04_BSExist
 * @description 二分查找 时间复杂度 O(log2n)
 * https://baike.baidu.com/item/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE/10628618?fr=aladdin
 * 表中元素按关键字有序排列(必要条件)
 * 查找在有序数组中 某个元素是否存在
 * @date 2021/10/19 15:50
 */
public class Code04_BSExist {
    /**
     * 利用二分查找给定的有序数组中是否存在指定额数
     *
     * @param arr 有序数组
     * @param num 查找的数
     * @return {@link boolean}
     **/

    public static boolean exist(int[] arr, int num) {
        return true;
    }


    //for test

    /**
     * 遍历数组确定是否存在num
     *
     * @param arr 数组
     * @param num 需要查找的数
     * @return {@link boolean}
     * @author wmx
     * @date 2021/10/19 16:34
     **/
    public static boolean findNum(int[] arr, int num) {
        for (int cur : arr) {
            if (num == cur) {
                return true;
            }
        }
        return false;
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
        int testTime = 10;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            //保证数组有序
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (findNum(arr, value) != exist(arr, value)) {
                ArrayUtils.printArray(arr);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "正确" : "错误");
    }
}
