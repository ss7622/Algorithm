class Solution {
    public static int solution(int[][] board, int[][] skill) {

        int dp[][] = new int[board.length+1][board[0].length+1];

        for (int[] s : skill) {
            int y1 = s[1], x1 = s[2], y2 = s[3], x2 = s[4];
            if(s[0] == 1){
                dp[y1][x1] -= s[5];
                dp[y1][x2+1] += s[5];
                dp[y2+1][x1] += s[5];
                dp[y2+1][x2+1] -= s[5];
            }
            else{
                dp[y1][x1] += s[5];
                dp[y1][x2+1] -= s[5];
                dp[y2+1][x1] -= s[5];
                dp[y2+1][x2+1] += s[5];
            }
        }

        for(int i=0;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j] += dp[i][j-1];
            }
        }

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] += dp[i-1][j];
            }
        }

        int cnt = 0;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] += dp[i][j];
                if(board[i][j] > 0){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}