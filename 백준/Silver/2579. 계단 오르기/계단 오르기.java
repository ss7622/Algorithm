import java.io.*;
import java.util.*;


public class Main {
    static int N=0,dp[],x[];
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        x = new int[N+1];
        dp = new int[N+1];

        for(int i = 1 ;i<=N;i++){
            x[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = x[1];
        if(N >= 2) {
            dp[2] = x[2] + x[1];
        }

        for(int  i = 3;i<=N;i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + x[i-1]) + x[i];
        }

        bw.write(dp[N] + "");
        bw.flush();

    }
}