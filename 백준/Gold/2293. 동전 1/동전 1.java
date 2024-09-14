import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] x = new int[N];
        int[] dp = new int[S+1];

        dp[0] = 1;

        for(int  i = 0 ;i<N;i++){
            x[i] = Integer.parseInt(br.readLine());
        }

        for(int  i = 0;i<N;i++){
            for(int j = 1;j<=S;j++){
                if(j - x[i] >= 0) {
                    dp[j] += dp[j - x[i]];
                }
            }
        }

        bw.write(dp[S] + "");
        bw.flush();
    }
}