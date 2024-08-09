import java.lang.*;
import  java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    static int N, e, edge[][], cnt = 0;
    static boolean visited[];

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        if(N == 1){
            bw.write("1");
            bw.flush();
            return;
        }
        e = Integer.parseInt(st.nextToken());

        edge = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0 ;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edge[a][b] = 1;
            edge[b][a] = 1;
        }

        for(int i = 1 ;i<=N;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(0, i);
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();

    }

    public static void dfs(int depth, int now){

        for(int  i = 1 ;i<=N;i++){
            if(edge[now][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(depth+1,i);
            }
        }
    }



}