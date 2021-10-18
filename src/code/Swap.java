package code;

/**
 * @author wmx
 * @version 1.0
 * @className Swap
 * @description  交换数组中对应下标元素
 * @date 2021/10/18 17:51
 */
public class Swap {
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
}
