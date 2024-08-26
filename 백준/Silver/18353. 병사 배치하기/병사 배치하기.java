import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int s;
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = Integer.parseInt(br.readLine());

        int dp[] = new int[s];
        int x[] = new int[s];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;

        for(int  i = 0 ;i<s;i++){
            x[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            max = Math.max(max,x[i]);
        }
        
        max = 1;


        for(int  i = 0 ;i<s;i++){
            for(int j = i+1 ;j<s;j++){
                if(x[i] > x[j]){
                    dp[j] = Math.max(dp[i]+1, dp[j]);
                }
                max = Math.max(dp[j],max);
            }
        }

        bw.write("" + (s-max));
        bw.flush();
    }
}