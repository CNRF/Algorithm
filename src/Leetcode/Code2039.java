package Leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/the-time-when-the-network-becomes-idle/
 *
 * @author wmx
 * @version 1.0
 * @className Code2039
 * @date 2022/3/20 20:26
 */
public class Code2039 {
    //找图的最短路径+时间延时的时间
    static int N = 100010, M = N * 2, INF = 0x3f3f3f3f;
    static int[] he = new int[N], e = new int[M], ne = new int[M];
    static int[] dist = new int[N];
    int idx;

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        Arrays.fill(he, -1);
        Arrays.fill(dist, INF);
        int n = patience.length;
        // 建图（链式前向星）
        for (int[] e : edges) {
            add(e[0], e[1]);
            add(e[1], e[0]);
        }
        // 计算最短路
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        dist[0] = 0;
        while (!d.isEmpty()) {
            int t = d.pollFirst();
            for (int i = he[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] != INF) continue;
                dist[j] = dist[t] + 1;
                d.addLast(j);
            }
        }
        // 计算空闲时间
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int di = dist[i] * 2, t = patience[i];
            int cur = di <= t ? di : (di - 1) / t * t + di;
            if (cur > ans) ans = cur;
        }
        return ans + 1;
    }
}
