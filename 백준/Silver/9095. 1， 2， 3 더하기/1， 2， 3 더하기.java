import java.io.*;
import java.util.*;


public class Main {
    static int N=0,dp[], cnt=0;
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ;i<T;i++) {
            N = Integer.parseInt(br.readLine());

            dfs(0);
            bw.write(cnt + "\n");
            bw.flush();

            cnt = 0;
        }


    }

    static void dfs(int depth){
        if(depth >= N) {
            if (depth == N) {
                cnt++;
            }
            return;
        }

        for(int  i =1;i<4;i++){
            dfs(depth+i);
        }
    }
}