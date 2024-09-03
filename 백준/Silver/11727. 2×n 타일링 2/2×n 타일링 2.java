import java.io.*;
import java.util.*;


public class Main {
    static int N=0;
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());

        int dp[] = new int[N+3];

        dp[1] = 1;
        dp[2] = 3;
        if(N > 2) {
            for (int j = 3; j <=N;j++){
                dp[j] = (dp[j-1] + (dp[j-2]*2)) % 10007;
            }
        }

        bw.write((dp[N]) + "");
        bw.flush();

    }
}