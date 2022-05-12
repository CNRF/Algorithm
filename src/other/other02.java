package other;

/**
 * 有100级阶梯    每次走1到2步，总共有多少种
 * 1 2 3
 *
 * @author mingxing.wang
 * @date 2022/5/5 15:49
 */
public class other02 {
    public static void main(String[] args) {

    }

    public Integer fn(int size) {
        if (size == 1) {
            return 1;
        }
        if (size == 2) {
            return 2;

        }
        return fn(size - 1) + fn(size - 2);
    }
}
