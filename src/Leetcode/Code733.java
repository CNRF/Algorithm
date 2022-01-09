package Leetcode;

import java.util.Stack;

/**
 * @author wmx
 * @version 1.0
 * @className Code733
 * @description
 * @date 2022/1/6 9:50
 */
public class Code733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return checkAndSet(sr, sc, image, image[sr][sc], newColor);
    }

    /**
     * DFS（Deep First Search）深度优先搜索
     *
     * @param x     开始节点x坐标
     * @param y     开始节点y坐标
     * @param image 需要染色的数组
     * @param oc    初始节点的旧颜色
     * @param nc    新颜色
     * @return 染色之后的数组
     */
    public static int[][] checkAndSet(int x, int y, int[][] image, int oc, int nc) {
        //当越界或者新旧颜色相同的时候不需要修改
        //image.length表示有行数,image[0].length表示有多少列
        if (x >= 0 && y >= 0 && x < image.length && y < image[0].length && image[x][y] == oc && oc != nc) {
            image[x][y] = nc;
            checkAndSet(x, y - 1, image, oc, nc);
            checkAndSet(x, y + 1, image, oc, nc);
            checkAndSet(x + 1, y, image, oc, nc);
            checkAndSet(x - 1, y, image, oc, nc);
        }
        return image;
    }

    //BFS（Breath First Search）广度优先搜索。

    /**
     * 广度优先搜索
     *
     * @param image    需要变换的数组
     * @param sr       开始节点x坐标
     * @param sc       开始节点y坐标
     * @param newColor 新颜色
     * @return
     */
    public static int[][] checkAndSetBFS(int[][] image, int sr, int sc, int newColor) {
        //存放节点信息的栈
        Stack<int[]> stack = new Stack<>();
        int oldColor = image[sr][sc];
        stack.add(new int[]{sr, sc});
        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            //检查越界条件和相同颜色问题
            if (p[0] >= 0 && p[1] >= 0 && p[0] < image.length && p[1] < image[0].length &&
                    image[p[0]][p[1]] == oldColor && oldColor != newColor) {
                image[p[0]][p[1]] = newColor;
                stack.add(new int[]{p[0], p[1] + 1});
                stack.add(new int[]{p[0], p[1] - 1});
                stack.add(new int[]{p[0] + 1, p[1]});
                stack.add(new int[]{p[0] - 1, p[1]});
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}, {1, 0, 1}
        };
        int[][] ints = floodFill(image, 1, 1, 2);
    }
}
