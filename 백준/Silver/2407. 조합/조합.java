import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static int n=0,r=0;
    static BigInteger dp[][];
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st  = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        dp = new BigInteger[n+1][r+1];

        bw.write(combi(n,r) + "");
        bw.flush();

    }
    static BigInteger combi(int n, int r){
        if(dp[n][r] == null) {
            if (n == r || r == 0) {
                return dp[n][r] = BigInteger.valueOf(1);
            }
            return dp[n][r] = combi(n - 1, r).add(combi(n - 1, r - 1));
        }
        return dp[n][r];
    }
}