import java.io.*;
import java.math.BigInteger;


public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        BigInteger dp[] = new BigInteger[N+2];

        dp[0] = BigInteger.valueOf(0);
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(1);

        for(int  i = 3 ;i<=N;i++){
            dp[i] = dp[i-1].add(dp[i-2]);
        }

        bw.write(dp[N] + "");
        bw.flush();
    }
}