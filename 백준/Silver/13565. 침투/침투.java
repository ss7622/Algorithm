import java.lang.*;
import  java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    static int N, M, x[][], check = 0;
    static int X[] = {0,0,1,-1}, Y[] = {1,-1,0,0};
    static boolean visited[][];

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];

        x = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                x[i][j] = line.charAt(j) - '0';
            }
        }

        for(int  i = 0 ;i<M;i++){
            if(x[0][i] == 0){
                dfs(0,i);
                if(check == 1){
                    bw.write("YES");
                    bw.flush();
                    return;
                }
            }

        }


        bw.write("NO");
        bw.flush();



    }

    public static void dfs(int now, int xx){
        if(now == N-1){
            check = 1;
            return;
        }


        for(int  j = 0; j<4;j++){
            int x1 = xx + X[j];
            int y1 = now + Y[j];
            if(x1>=0 && x1 < M && y1 >= 0 && y1 < N){
                if(x[y1][x1] == 0 && !visited[y1][x1]){
                    visited[y1][x1] = true;
                    dfs(y1,x1);
                }
            }
        }

    }



}