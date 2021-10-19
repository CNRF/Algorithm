package code;

/**
 * @author wmx
 * @version 1.0
 * @className Code07_BSAwesome
 * @description 利用二分查找在    一个无序并且任意两个相邻的数不相同的数组中的局部最小位置（只要一个满足即可）
 * @date 2021/10/19 16:08
 */
public class Code07_BSAwesome {
    /**
     * 查找数组中的任意一个局部最小值
     *
     * @param arr
     * @return {@link int}
     * @author wmx
     * @date 2021/10/19 17:37
     **/
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
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
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            ArrayUtils.printArray(arr);
            int lessIndex = getLessIndex(arr);
            System.out.println(lessIndex);
        }

    }
}
