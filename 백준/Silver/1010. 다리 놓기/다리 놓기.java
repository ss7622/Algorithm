import java.io.*;
import java.util.*;


public class Main {
    static int N=0,dp[][];
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for(int i = 0 ;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dp = new int[b+1][a+1];

            bw.write(combi(b,a) + "\n");
            bw.flush();

        }
    }

    static int combi(int n, int r){
        if(dp[n][r] != 0){
            return dp[n][r];
        }
        if(n == r || r == 0){
            dp[n][r] = 1;
            return 1;
        }
        return dp[n][r] = combi(n-1,r-1) + combi(n-1,r);
    }
}