package code;

/**
 * @author wmx
 * @version 1.0
 * @className Code02_BubbleSort
 * @description 冒泡排序  O(n²)
 * https://baike.baidu.com/item/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F/4602306?fr=aladdin
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
 * @date 2021/10/19 14:36
 */
public class Code02_BubbleSort {
    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     * @author wmx
     * @date 2021/10/19 14:40
     **/
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //进行正常的数据处理
        for (int i = arr.length - 1; i > 0; i--) {
            //保证后面的数是有序的
            for (int j = 0; j < i; j++) {
                //当j循环到最后，arr[j]是最大，此时和arr[j+1]比较，保证arr[j]<arr[j+1]
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    //for test
    public static void main(String[] args) {
        int testTime = 10000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtils.copyArray(arr1);
            bubbleSort(arr1);
            ArrayUtils.comparator(arr2);
            if (!ArrayUtils.isEqual(arr1, arr2)) {
                //打印出出错的数据
                succeed = false;
                ArrayUtils.printArray(arr1);
                ArrayUtils.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "正确" : "错误");

    }
}
