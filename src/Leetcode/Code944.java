package Leetcode;

import java.util.LinkedList;

/**
 * @author wmx
 * @version 1.0
 * @className Code944
 * @description https://leetcode-cn.com/problems/rotting-oranges/solution/yan-du-you-xian-sou-suo-python3-c-by-z1m/
 * @date 2022/1/9 10:19
 */
public class Code944 {
    public static int orangesRotting(int[][] grid) {
        //新鲜橘子的数量
        int fresh = 0;
        //全部腐烂需要的时间
        int minute = 0;
        //腐烂橘子的下标
        LinkedList<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty() && fresh > 0) {
            minute++;
            //当前队列的大小，只遍历当前队列（新增不管）
            int size = queue.size();
            for (int d = 0; d < size; d++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        fresh = fresh - 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }

        }
        if (fresh != 0) {
            return -1;
        }
        return minute;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {2, 1, 1}, {0, 1, 1}, {1, 0, 1}
        };
        int ints = orangesRotting(mat);
        System.out.println(ints);

    }
}
