
import java.lang.*;
import  java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    static int N, x[], M,cnt=0,now=0;
    static boolean visited[];
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for(int  i = 0 ;i<N;i++){
            M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = new int[M+1];
            visited = new boolean[M+1];
            for(int  j = 1;j<M+1;j++){
                x[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1;j<M+1;j++){
                now = j;
                if(!visited[j]) {
                    visited[j] = true;
                    dfs(now, j);
                }
            }

            bw.write(String.valueOf(cnt));
            bw.write("\n");
            bw.flush();

            cnt = 0;


        }

    }

    public static void dfs(int now, int start){


        visited[start] = true;
        
        if(now == x[start]){
            cnt++;
            return;
        }

        dfs(now,x[start]);

    }
}