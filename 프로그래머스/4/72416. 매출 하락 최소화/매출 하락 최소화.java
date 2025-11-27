import java.util.*;

class Solution {

    static int[][] dp;
    static int[] salesArr;
    static Map<Integer, List<Integer>> graph;

    public int solution(int[] sales, int[][] links) {

        int n = sales.length;
        dp = new int[n+1][2];
        salesArr = new int[n+1];

        for (int i=1; i<=n; i++) {
            salesArr[i] = sales[i-1];
        }

        graph = new HashMap<>();
        for (int i=1;i<=n;i++) graph.put(i,new ArrayList<>());

        for (int[] l : links) {
            graph.get(l[0]).add(l[1]);
        }

        dfs(1);

        return Math.min(dp[1][0], dp[1][1]);
    }

    public static void dfs(int now) {

        List<Integer> children = graph.get(now);

        // leaf node
        if (children.isEmpty()) {
            dp[now][0] = 0;
            dp[now][1] = salesArr[now];
            return;
        }

        int sum0 = 0;  // Σ(min child)
        int extra = Integer.MAX_VALUE;  // 최소 한명 참석시키기 위한 추가비용

        for (int child : children) {
            dfs(child);

            int childMin = Math.min(dp[child][0], dp[child][1]);
            sum0 += childMin;

            // extra 후보 계산
            extra = Math.min(extra, dp[child][1] - childMin);
        }

        // now 참석
        dp[now][1] = salesArr[now] + sum0;

        // now 불참 → 자식 중 최소 1명 참석해야 함
        dp[now][0] = sum0 + extra;
    }
}
