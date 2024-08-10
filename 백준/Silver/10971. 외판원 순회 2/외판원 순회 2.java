import java.lang.*;
import  java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    static int N, edge[][], start = 0, min = 10000001;
    static boolean visited[];

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        edge = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int  i = 1 ;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int  j = 1 ;j<=N;j++){
                edge[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int  i = 1 ;i<=N;i++){
            start = i;
            visited[i] = true;
            dfs(i,0,0);
        }

        bw.write(min + "\n");
        bw.flush();


    }

    public static void dfs(int now, int depth, int sum){
        if(depth == N-1){
            if(edge[now][start] == 0) {
                sum += 1000001;
            }
            sum += edge[now][start];
            if(sum < min){
                min = sum;
            }
            return;
        }

        for(int  i =1;i<=N;i++){
            if(edge[now][i] != 0 && !visited[i]){
                visited[i] = true;
                dfs(i,depth+1, sum + edge[now][i]);
                visited[i] = false;
            }
        }
    }



}