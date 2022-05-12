package practice.code;

import code.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wmx
 * @version 1.0
 * @className Code10_EvenTimesKM
 * @description 一个数组中有一种数可能出现K次，其他数都出现了M次，
 * M > 1,  K < M
 * 找到，出现了K次的数， ，不存在出现k次的数，返回-1
 * 要求，额外空间复杂度O(1)，时间复杂度O(N)(排除Hash表的形式)
 * @date 2021/10/20 10:39
 */
public class Code10_EvenTimesKM {
    /**
     * 一个数组中有一种数出现K次，其他数都出现了M次，找出出现K次的数
     *
     * @param arr 数组
     * @param k   出现较少的数次数
     * @param m   出现较多的的数次数
     * @return {@link int}
     * @author wmx
     * @date 2021/10/20 14:27
     **/
    public static int onlyKTimes(int[] arr, int k, int m) {

        return 0;
    }

    /**
     * hash表查询出现K次的数
     *
     * @param arr 数组
     * @param k   出现较少的数次数
     * @param m   出现较多的的数次数
     * @return {@link int}
     * @author wmx
     * @date 2021/10/20 15:27
     **/
    //for test
    public static int test(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }
        return -1;
    }

    /**
     * @param maxKinds 出现数的种类最大有maxKinds种
     * @param range    出现数的最大，最小值的范围
     * @param k        出现较少的数的次数k
     * @param m        出现较多次数的数的次数m
     * @return
     */
    //for test
    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        //出现K次的数的值
        int kTimeNum = randomNumber(range);
        // 可能出现K次，或者出现小于m次的数（非K）次的数的次数
        int times = Math.random() < 0.5 ? k : ((int) (Math.random() * (m - 1)) + 1);
        //随机生成出现数的个数  保证种数大于2
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        //算出数组长度 k+(numKinds-1)*m,初始化数组
        int[] arr = new int[times + (numKinds - 1) * m];
        int index = 0;
        for (; index < times; index++) {
            arr[index] = kTimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        //将出现K次的数加入到set中，避免重复
        set.add(kTimeNum);
        //将剩下出现m次的数填入数组中
        while (numKinds != 0) {
            int curNum = 0;
            //保证每次填的数不是同一个
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        //arr生成完成，顺序一定，打乱顺序
        for (int i = 0; i < arr.length; i++) {
            // i 位置的数，我想随机和j位置的数做交换
            int j = (int) (Math.random() * arr.length);// 0 ~ N-1
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }

    /**
     * 生成指定范围的数[-rang,+rang]
     *
     * @param range 生成数的范围
     * @return
     */
    //for test
    private static int randomNumber(int range) {
        return ((int) ((Math.random() * range) + 1)) - ((int) ((Math.random() * range) + 1));
    }

    //for test
    public static void main(String[] args) {
        int maxKinds = 100;
        int range = 200;
        int testTime = 10000;
        int max = 9;
        System.out.println("开始");
        for (int i = 0; i < testTime; i++) {
            //生成1~9之间的两个数a,b
            int a = ((int) (Math.random() * max)) + 1;
            int b = ((int) (Math.random() * max)) + 1;
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            //保证m,k都不相等
            if (m == k) {
                m = m + 1;
            }
            int[] arr = randomArray(maxKinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans2 = onlyKTimes(arr, k, m);
            if (ans1 != ans2) {
                System.out.println("m:" + m + "k:" + k);
                System.out.println("hash正确值" + ans1);
                System.out.println("code返回值" + ans2);
                ArrayUtils.printArray(arr);
                System.out.println("出错");
            }
        }
        System.out.println("测试结束");
    }
}
