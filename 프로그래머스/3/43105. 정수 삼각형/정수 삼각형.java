class Solution {
    public static int solution(int[][] triangle) {
        int dp[][] = new int[triangle.length][];

        int n = triangle.length;

        for(int i=0; i<n; i++) {
            dp[i] = new int[triangle[i].length];
        }

        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[1][0] + triangle[0][0];
        dp[1][1] = triangle[1][1] + triangle[0][0];

        int max = 0;

        for(int i=2; i<n; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][0];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(triangle[i][j] + dp[i - 1][j], triangle[i][j] + dp[i - 1][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}