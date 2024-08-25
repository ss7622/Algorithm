import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for(int  i = 0 ;i<=N;i++){
            dp[i] = -1;
        }
        dp[0] = dp[1] = 0;
        int k = cur(N,dp);

        bw.write("" + k);
        bw.flush();


    }

    public static int cur(int N, int dp[]){
        if(dp[N] == -1) {
            if(N % 6 == 0){
                dp[N] = Math.min(cur(N/3,dp), Math.min(cur(N/2,dp), cur(N-1,dp)))+1;
            }
            else if (N % 3 == 0) {
                dp[N] = Math.min(cur(N-1,dp),cur(N / 3, dp))+1;
                return dp[N];
            } else if (N % 2 == 0) {
                dp[N] = Math.min(cur(N/2,dp),cur(N-1,dp))+1;
                return dp[N];
            }
            else{
                dp[N] = cur(N-1,dp)+1;
                return dp[N];
            }
        }
        return dp[N];
    }

}