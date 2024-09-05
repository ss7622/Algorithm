import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static int N=0,x[],dp[], max = 0;
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = new int[N];
        dp = new int[N];

        for(int  i = 0 ;i<N;i++){
            x[i] = Integer.parseInt(st.nextToken());
            dp[i] = x[i];
        }
        max = dp[0];
        for(int  i = 1 ;i<N;i++){
            dp[i] = Math.max(dp[i] + dp[i-1], dp[i]);
            max = Math.max(dp[i], max);
        }

        bw.write(max + "");
        bw.flush();
    }
}