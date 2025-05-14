import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][3]; // 비용 입력 배열
        int[][] dp = new int[n + 1][3];  // 색별 최소 비용 저장 (0: R, 1: G, 2: B)

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // R
            arr[i][1] = Integer.parseInt(st.nextToken()); // G
            arr[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        // 초기값 설정 (1번 집)
        dp[1][0] = arr[1][0]; // R
        dp[1][1] = arr[1][1]; // G
        dp[1][2] = arr[1][2]; // B

        // 점화식 적용
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0]; // 현재 집 R → 이전 집은 G or B
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1]; // 현재 집 G
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2]; // 현재 집 B
        }

        // 마지막 집까지 칠한 후 최소 비용
        int answer = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        System.out.println(answer);
    }
}
