import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<int[]>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] p : paths) {
            graph[p[0]].add(new int[]{p[1], p[2]});
            graph[p[1]].add(new int[]{p[0], p[2]});
        }

        boolean[] isSummit = new boolean[n + 1];
        for (int s : summits) isSummit[s] = true;

        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int g : gates) {
            intensity[g] = 0;
            pq.offer(new int[]{g, 0});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], inten = cur[1];
            if (isSummit[node] || inten > intensity[node]) continue;
            for (int[] next : graph[node]) {
                int ni = Math.max(inten, next[1]);
                if (ni < intensity[next[0]]) {
                    intensity[next[0]] = ni;
                    pq.offer(new int[]{next[0], ni});
                }
            }
        }

        Arrays.sort(summits);
        int res = summits[0], min = intensity[res];
        for (int s : summits) {
            if (intensity[s] < min) {
                res = s;
                min = intensity[s];
            }
        }
        return new int[]{res, min};
    }
}
