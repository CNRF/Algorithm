package Leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author wmx
 * @version 1.0
 * @className Code539
 * @description https://leetcode-cn.com/problems/minimum-time-difference/
 * @date 2022/1/18 9:34
 */
public class Code539 {
    public static int findMinDifference(List<String> timePoints) {
        int length = timePoints.size();
        //当list的大小大于1440，说明有两个时间点相同
        if (length > 24 * 60) {
            return 0;
        }
        //存放当天时间和下一天时间
        int[] cnt = new int[1440 * 2 + 10];
        for (String timePoint : timePoints) {
            String[] ss = timePoint.split(":");
            int h = Integer.parseInt(ss[0]);
            int m = Integer.parseInt(ss[1]);
            //时间点作为下标，大于1说明时间点有两个相同
            cnt[h * 60 + m]++;
            cnt[h * 60 + m + 1440]++;
        }
        int ans = 1440;
        int last = -1;
        for (int i = 0; i <= 1440 * 2 && ans != 0; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            if (cnt[i] > 1) {
                ans = 0;
            } else if (last != -1) {
                ans = Math.min(ans, i - last);
            }
            last = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("23:59", "00:00");
        int minDifference = findMinDifference(timePoints);
        System.out.println(minDifference);
    }
}
