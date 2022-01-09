package Leetcode;

import java.util.LinkedList;

/**
 * @author wmx
 * @version 1.0
 * @className Code542A1
 * @description https://leetcode-cn.com/problems/01-matrix/
 * @date 2022/1/9 9:05
 */
public class Code542A1 {
    public static int[][] updateMatrix(int[][] mat) {
        //遍历mat，将值为0的数的下标放进队列中，并且将 1 的位置设置成 -1
        LinkedList<int[]> queue = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && mat[newX][newY] == -1) {
                    mat[newX][newY] = mat[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {0, 0, 0}, {0, 1, 0}, {1, 1, 1}
        };
        int[][] ints = updateMatrix(mat);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
