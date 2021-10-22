package code;

/**
 * @author wmx
 * @version 1.0
 * @className Code03_InsertionSort
 * @description 插入排序 O(n²)
 * https://www.runoob.com/data-structures/insertion-sort.html
 * 使用双层循环，外层循环对除了第一个元素之外的所有元素，内层循环对当前元素前面有序表进行待插入位置查找，并进行移动
 * @date 2021/10/19 14:54
 */
public class Code03_InsertionSort {
    /**
     * 插入排序
     *
     * @param arr 需要排序的数组
     * @return
     * @author wmx
     * @date 2021/10/19 15:05
     **/
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //正常的数组进行排序
        //先保证0~i的数保证要有序
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                ArrayUtils.swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 10000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrayUtils.generateRandomArray(maxSize, maxValue);
            int[] arr1 = ArrayUtils.copyArray(arr);
            int[] arr2 = ArrayUtils.copyArray(arr);
            insertionSort(arr1);
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
