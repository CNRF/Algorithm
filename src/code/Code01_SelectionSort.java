package code;

/**
 * @author wmx
 * @version 1.0
 * @ClassName Code01_SelectionSort
 * @Description 选择排序 时间复杂度为 O(n²)
 *
 * https://baike.baidu.com/item/%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F/9762418?fr=aladdin
 * 0 ~ N-1  找到最小值，在哪，放到0位置上
 * 1 ~ N-1  找到最小值，在哪，放到1 位置上
 * 2 ~ N-1  找到最小值，在哪，放到2 位置上
 * @date 2021/10/11 17:25
 *
 */
public class Code01_SelectionSort {
    /**
     * 对传入的数据进行选择排序
     * @param arr
     * @return
     * @author wmx
     * @date 2021/10/18 17:54
     **/
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
            ArrayUtils.swap(arr, i, minIndex);
        }
    }
    // for test
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
