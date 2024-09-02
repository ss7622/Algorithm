import java.io.*;
import java.util.*;


public class Main {
    static int N=0,dp[], cnt=0;
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());

        int dp[] = new int[N+3];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        if(N > 3) {
            for (int j = 4; j <=N;j++){
                dp[j] = (dp[j-1] + dp[j-2]) % 10007;
            }
        }

        bw.write((dp[N]) + "");
        bw.flush();

    }
}