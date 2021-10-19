package code;

import java.util.Arrays;

/**
 * @author wmx
 * @version 1.0
 * @className Swap
 * @description  交换数组中对应下标元素
 * @date 2021/10/18 17:51
 */
public class ArrayUtils {
    /**
     * 交换数组中两个下标的元素
     *
     * @param arr 数组
     * @param i   数组下标1
     * @param j   数组下标2
     * @return int[] 返回交换后的数组元素
     * @author wmx
     * @date 2021/10/18 17:33
     **/
    public static int[] swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }
    /**
     *  JDK自带排序，验证数组是否排序正确
     * @param arr 需要排序的数组
     * @return
     * @author wmx
     * @date 2021/10/19 9:25
     **/
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    /**
     * 判断两个数组是否相同，相同返回True，不同为false
     * @param arr1 需要比较的数组1
     * @param arr2 需要比较的数组1
     * @return {@link boolean}
     * @author wmx
     * @date 2021/10/19 9:27
     **/
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
    /**
     * 复制产生相同元素的数组
     * @param arr
     * @return {@link int[]}
     * @author wmx
     * @date 2021/10/19 9:30
     **/
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
    /**
     * 打印传入数组的全部元素
     * @param arr int类型的数组
     * @return
     * @author wmx
     * @date 2021/10/19 9:31
     **/
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }
    /**
     * 构建对数器，产生随机数组对代码进行验证工作
     * @param maxSize 需要进行测试的次数
     * @param maxValue 产生数组中的最大值
     * @return {@link int[]}
     * @author wmx
     * @date 2021/10/19 9:32
     **/

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

}
