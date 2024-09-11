import java.io.*;
import java.util.*;


public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        int[] t = new int[N];
        int[] p = new int[N];

        for(int  i = 0 ;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        
        if(t[N-1]==1){
            dp[N-1] = p[N-1];
        }

        for(int  i = N-2 ;i>=0;i--){
            if(i + t[i] <= N){
                dp[i] = p[i];
                if(i+t[i] < N){
                    dp[i] += dp[i+t[i]];
                }
                dp[i] = Math.max(dp[i],dp[i+1]);
            }
            else{
                dp[i] = dp[i+1];
            }
        }

        bw.write(String.valueOf(dp[0]));
        bw.flush();
    }
}