package Leetcode;

/**
 * https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 * @author mingxing.wang
 * @date 2022/4/26 15:48
 */
public class Code883 {
    public int projectionArea(int[][] grid) {
        //俯视为数组中不为0个数，从前面则是每一列中最大数之和，从侧边则是每一行最大数之和
        int ans1=0,ans2=0,ans3=0;
        int length= grid.length;
        for (int i = 0; i < length; i++) {
            int a=0,b=0;
            for (int j = 0; j < length; j++) {
                if (grid[i][j]>0) ans1++;
                a=Math.max(a,grid[i][j]);
                b=Math.max(b,grid[j][i]);
            }
            ans2+=a;
            ans3+=b;
        }
        return ans1+ans2+ans3;
    }
}
