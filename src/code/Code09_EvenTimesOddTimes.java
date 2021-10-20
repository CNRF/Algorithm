package code;

/**
 * @author wmx
 * @version 1.0
 * @className Code08_EvenTimesOddTimes
 * @description 数组中一个或者两个数出现奇数次
 * @date 2021/10/19 17:56
 */
public class Code09_EvenTimesOddTimes {
    /**
     * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次
     *
     * @param arr 有一种数出现奇数次的数组
     * @return
     * @author wmx
     * @date 2021/10/20 10:04
     **/
    public static void printOddTimesNum(int[] arr) {
        int eor = 0;
        //根据N^N=0  出现偶数次的数都消除
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    /**
     * 一个数组有两个数出现奇数次，其他数出现偶数次
     *
     * @param arr 两个数出现奇数次的数组
     * @return
     * @author wmx
     * @date 2021/10/20 10:26
     **/
    public static void printOddTimesNums(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
/*        a b 是出现奇数次的两种数
        上述循环之后eor=a^b 且eor!-0
        获取到eor的二进制中最右侧为1的数
        如 eor ： 00110010110111000
       rightOne:  00000000000001000
        */
        int rightOne = eor & (-eor);
//      int  rightOne=eor&(~eor+1)
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                //将数组进行分组，分为在eor最右侧1位置 是1 和0 两组
                //arr[i]&rightOne)!=0 获取到的数是最右侧为1的数
                //此时 onlyOne^=arr[i];会获取到最右侧为1的出现奇数次的数
                onlyOne ^= arr[i];
            }
        }
        //b为出现奇数次的另外一个数
        int b = eor ^ onlyOne;
        System.out.println(onlyOne + " " + b);
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        printOddTimesNum(arr1);

        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        printOddTimesNums(arr2);
    }
}
