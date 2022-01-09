package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code695
 * @description https://leetcode-cn.com/problems/max-area-of-island/
 * @date 2022/1/6 21:27
 */
public class Code695 {
    //偏移数组,在dfs中查找当前节点上下左右节点
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private int n, m;
    private int[][] g;

    public int dfs(int x, int y) //搜索函数
    {
        int area = 1;
        g[x][y] = 0; //已经搜索过，标记为0
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            //当前土地未出界也未被搜索过，继续下一层搜索
            if (a >= 0 && a < n && b >= 0 && b < m && g[a][b] != 0)
                area += dfs(a, b);
        }
        return area; //返回连通土地总数
    }

    public int maxAreaOfIsland(int[][] grid) {
        //使用全局数组，不改变输入项
        g = grid;
        int res = 0;
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (g[i][j] != 0)
                    res = Math.max(res, dfs(i, j));
        return res;

    }
}
