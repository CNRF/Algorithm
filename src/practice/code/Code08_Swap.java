package practice.code;

/**
 * @author wmx
 * @version 1.0
 * @className Code08_Swap
 * @description 如何不用额外变量交换两个数
 * @date 2021/10/20 9:33
 */
public class Code08_Swap {
    /**
     * 不使用额外的变量交换两个数
     * (a,b不能是同一块内存区域，如arr[0]和arr[0]进行交换)
     *
     * @param a 交换数1
     * @param b 交换数2
     * @return
     * @author wmx
     * @date 2021/10/20 9:34
     **/
    public static int[] swap(int a, int b) {
        return new int[]{};
    }

    //for test
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        int[] swap = swap(a, b);
        System.out.println("a=" + swap[0]);
        System.out.println("b=" + swap[1]);
    }
}
