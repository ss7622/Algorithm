class Solution {

    private final int[] dx = {1, 0, 0, -1};              // d, l, r, u
    private final int[] dy = {0, -1, 1, 0};
    private final char[] dir = {'d', 'l', 'r', 'u'};     // 사전순

    private String answer = "impossible";
    private boolean found = false;
    private int targetX, targetY, limit, rows, cols;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        rows = n;
        cols = m;
        targetX = r;
        targetY = c;
        limit = k;

        dfs(x, y, 0, new StringBuilder(), 0);
        return answer;
    }

    private void dfs(int x, int y, int depth, StringBuilder path, int start) {
        if (found) return;

        int dist = Math.abs(x - targetX) + Math.abs(y - targetY);

        // pruning
        if (depth + dist > limit || (limit - depth - dist) % 2 != 0) return;

        if (depth == limit) {
            if (x == targetX && y == targetY) {
                answer = path.toString();
                found = true;
            }
            return;
        }

        for (int i = start; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && nx <= rows && ny >= 1 && ny <= cols) {
                path.append(dir[i]);
                dfs(nx, ny, depth + 1, path, 0); // 다음 depth는 다시 0부터
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
