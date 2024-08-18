import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,x[][], max = 0;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        x = new int[N][3];
        for(int  i = 0 ;i<N;i++){
            StringTokenizer st  = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            x[i][0] = start;
            x[i][1] = end;
            x[i][2] = num;
        }

        dfs(0,0);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    public static void dfs(int sum, int now){
        if(max < sum){
            max = sum;
        }

        for(int  i = 0 ;i<N;i++){
            if(now <= x[i][0]){
                dfs(sum + x[i][2], x[i][1]);
            }
        }
    }



}