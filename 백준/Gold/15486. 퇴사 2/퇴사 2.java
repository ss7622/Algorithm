import java.io.*;
import java.util.*;


public class Main {
    static int max = 0, dp[], t[],p[],N;
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new int[N];
        t = new int[N];
        p = new int[N];

        for(int  i = 0 ;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int  i = N-1 ;i>=0;i--){
            if(i + t[i] <= N){
                dp[i] = p[i];
                if(i+t[i] < N){
                    dp[i] += dp[i+t[i]];
                }
                for(int j = i+1; j < i+t[i];j++){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            else{
                if(i != N-1){
                    dp[i] = dp[i+1];
                }
            }
            max = Math.max(max,dp[i]);
        }

        bw.write(max + "");
        bw.flush();
    }
}