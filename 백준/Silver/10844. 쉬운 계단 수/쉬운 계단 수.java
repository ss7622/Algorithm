import java.io.*;
import java.math.BigInteger;
import java.util.Objects;


public class Main {
    static int N=0;
    static BigInteger dp[][];
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new BigInteger[10][N+1];

        for(int  i = 0;i<10;i++){
            for(int j = 0;j<N+1;j++){
                dp[i][j] = BigInteger.valueOf(-1);
            }
        }
        BigInteger sum = BigInteger.valueOf(0);
        for (int  i = 1;i<10;i++){
            sum = sum.add(cur(i,1));
            sum = sum.mod(BigInteger.valueOf(1000000000));
        }

        bw.write(sum + "");
        bw.flush();
    }

    static BigInteger cur(int now, int depth){
        if(now < 0 || now > 9){
            return BigInteger.valueOf(0);
        }
        if(!Objects.equals(dp[now][depth], BigInteger.valueOf(-1))){
            return dp[now][depth];
        }
        if(depth == N){
            return BigInteger.valueOf(1);
        }
        return dp[now][depth] = cur(now+1, depth+1).add(cur(now-1, depth+1));
    }
}