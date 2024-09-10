import java.io.*;
import java.util.*;


public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int dp[] = new int[N+3];
        int x[] = new int[N+3];
        x[0] = 0;
        for(int  i = 1 ;i<=N;i++){
            x[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = x[1];
        dp[2] = x[1] + x[2];
        dp[3] = Math.max(x[2], x[1]) + x[3];

        int max = dp[2];

        for(int i = 4;i<=N;i++){
            dp[i] = Math.max(Math.max(x[i-1] + dp[i-3], dp[i-2]),x[i-1] + dp[i-4]) + x[i];
            max = Math.max(max,dp[i]);
        }

        bw.write(max + "");
        bw.flush();
    }
}