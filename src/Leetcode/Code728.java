package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/self-dividing-numbers/
 *
 * @author mingxing.wang
 * @date 2022/3/31 11:38
 */
public class Code728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = left; i < right + 1; i++) {
            if (check(i)) {
                result.add(i);
            }
        }
        return result;
    }

    boolean check(int num) {
        int temp = num;
        while (temp > 0) {
            int i = temp % 10;
            if (i == 0 || num % i != 0) {
                return false;
            }
            temp = temp / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> integers = new Code728().selfDividingNumbers(1, 22);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
