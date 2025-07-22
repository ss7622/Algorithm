class Solution {
    int[] dx = {1, 0, 0, -1}; // d, l, r, u
    int[] dy = {0, -1, 1, 0};
    char[] dir = {'d', 'l', 'r', 'u'};
    String answer = "impossible";
    boolean found = false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > k || (k - dist) % 2 != 0) return "impossible";

        dfs(n, m, x, y, r, c, k, 0, new StringBuilder());
        return answer;
    }

    private void dfs(int n, int m, int x, int y, int r, int c, int k, int depth, StringBuilder path) {
        if (found) return;

        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (depth + dist > k) return;

        if (depth == k) {
            if (x == r && y == c) {
                answer = path.toString();
                found = true;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

            path.append(dir[i]);
            dfs(n, m, nx, ny, r, c, k, depth + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
