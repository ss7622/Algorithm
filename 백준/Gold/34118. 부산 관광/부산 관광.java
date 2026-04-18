import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 400000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String as = br.readLine();
        String bs = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int p1 = Integer.parseInt(st.nextToken());
        int p3 = Integer.parseInt(st.nextToken());
        int p5 = Integer.parseInt(st.nextToken());
        int pPair = Integer.parseInt(st.nextToken());

        // dp[j][k] : 한국이는 오늘 포함 j일, 정올이는 오늘 포함 k일 티켓이 남았을 때의 최소 비용
        int[][] dp = new int[6][6];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0; // 시작 시점의 비용은 0

        for (int i = 0; i < n; i++) {
            int[][] nextDp = new int[6][6];
            for (int[] row : nextDp) Arrays.fill(row, INF);

            // 1. 하루가 지남 (남은 티켓 기간 1일 감소)
            for (int j = 0; j <= 5; j++) {
                for (int k = 0; k <= 5; k++) {
                    if (dp[j][k] != INF) {
                        int nj = Math.max(0, j - 1);
                        int nk = Math.max(0, k - 1);
                        nextDp[nj][nk] = Math.min(nextDp[nj][nk], dp[j][k]);
                    }
                }
            }
            dp = nextDp;

            // 2. 티켓 구매 로직 (두 사람이 각자 독립적으로 구매할 수 있도록 2번 반복)
            for (int step = 0; step < 2; step++) {
                int[][] temp = new int[6][6];
                for (int j = 0; j <= 5; j++) {
                    for (int k = 0; k <= 5; k++) temp[j][k] = dp[j][k];
                }
                
                for (int j = 0; j <= 5; j++) {
                    for (int k = 0; k <= 5; k++) {
                        if (dp[j][k] == INF) continue;

                        // 한국이 개별 티켓 구매 (Math.max를 통해 남은 기간 연장)
                        temp[Math.max(j, 1)][k] = Math.min(temp[Math.max(j, 1)][k], dp[j][k] + p1);
                        temp[Math.max(j, 3)][k] = Math.min(temp[Math.max(j, 3)][k], dp[j][k] + p3);
                        temp[Math.max(j, 5)][k] = Math.min(temp[Math.max(j, 5)][k], dp[j][k] + p5);

                        // 정올이 개별 티켓 구매
                        temp[j][Math.max(k, 1)] = Math.min(temp[j][Math.max(k, 1)], dp[j][k] + p1);
                        temp[j][Math.max(k, 3)] = Math.min(temp[j][Math.max(k, 3)], dp[j][k] + p3);
                        temp[j][Math.max(k, 5)] = Math.min(temp[j][Math.max(k, 5)], dp[j][k] + p5);

                        // 묶음권 구매 (두 사람 모두 4일 연장)
                        temp[Math.max(j, 4)][Math.max(k, 4)] = Math.min(temp[Math.max(j, 4)][Math.max(k, 4)], dp[j][k] + pPair);
                    }
                }
                dp = temp;
            }

            // 3. 오늘 관광을 해야 하는데 유효한 티켓이 없는 경우 불가능(INF) 처리
            boolean aNeeds = as.charAt(i) == '1';
            boolean bNeeds = bs.charAt(i) == '1';
            
            for (int j = 0; j <= 5; j++) {
                for (int k = 0; k <= 5; k++) {
                    if (aNeeds && j == 0) dp[j][k] = INF;
                    if (bNeeds && k == 0) dp[j][k] = INF;
                }
            }
        }

        // 4. 모든 일정이 끝난 후의 최소 비용 도출
        int minCost = INF;
        for (int j = 0; j <= 5; j++) {
            for (int k = 0; k <= 5; k++) {
                minCost = Math.min(minCost, dp[j][k]);
            }
        }
        
        System.out.println(minCost);
    }
}