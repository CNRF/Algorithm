package offer;

/**
 * @author wmx
 * @version 1.0
 * @className Code04
 * @description https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @date 2022/1/9 8:30
 */
public class Code04 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        };
        boolean numberIn2DArray = findNumberIn2DArray(image, 31);
        System.out.println(numberIn2DArray);
    }
}
