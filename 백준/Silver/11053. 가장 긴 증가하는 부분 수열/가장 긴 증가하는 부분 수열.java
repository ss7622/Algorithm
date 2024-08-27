import java.io.*;
import java.util.*;


public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x[] = new int[N];
        int dp[] = new int[N];

        for(int i = 0 ;i<N;i++){
            x[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = 1;

        for(int i = 0 ;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(x[i] < x[j]){
                    dp[j] = Math.max(dp[i]+1,dp[j]);
                }
            }
            max = Math.max(max,dp[i]);
        }

        bw.write("" + max);
        bw.flush();
    }
}