import java.io.*;
import java.util.*;


public class Main {
    static int N=0,T,x[][];
    static int dp[][];
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for(int  i = 0 ;i<T;i++){
            N = Integer.parseInt(br.readLine());

            x = new int[2][N+1];
            dp = new int[2][N+1];

            for(int j=0;j<2;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0 ;k<N;k++){
                    x[j][k] = Integer.parseInt(st.nextToken());
                    dp[j][k] = -1;
                }
            }

            dp[0][0] = x[0][0];
            dp[1][0] = x[1][0];
            dp[0][1] = x[0][1] + x[1][0];
            dp[1][1] = x[1][1] + x[0][0];

            int max = Math.max(cur(N-1,0),cur(N-1,1));

            bw.write(max + "\n");
            bw.flush();

        }
    }

    static int cur(int x1, int y1){
        if(x1 < 0){
            return 0;
        }
        if(dp[y1][x1] == -1){
            if(y1 == 0) {
                return dp[y1][x1] = x[y1][x1]+ Math.max(cur(x1-2,1),cur(x1-1,1));
            }
            else {
                return dp[y1][x1] = x[y1][x1]+ Math.max(cur(x1-2,0),cur(x1-1,0));
            }
        }
        return dp[y1][x1];
    }

}