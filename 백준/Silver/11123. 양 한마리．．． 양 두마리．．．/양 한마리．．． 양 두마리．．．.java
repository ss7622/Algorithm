import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int T,H,W,cnt = 0;
    static int X[] = {0,0,-1,1}, Y[] = {-1,1,0,0};
    static char[][] x;
    static boolean visited[][];

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for(int i = 0 ;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            x = new char[H][W];
            visited = new boolean[H][W];

            for(int  j = 0;j<H;j++){
                x[j] = br.readLine().toCharArray();
            }

            for(int j = 0 ;j<H;j++){
                for(int k = 0 ;k<W;k++){
                    if(x[j][k] == '#' && !visited[j][k]){
                        cnt++;
                        visited[j][k] = true;
                        dfs(k,j);
                    }
                }
            }

            bw.write(cnt + "\n");
            bw.flush();

            cnt = 0;
        }

    }

    public static void dfs(int xx,int yy){
        for(int  i = 0 ;i<4;i++){
            int a = xx + X[i];
            int b = yy + Y[i];

            if(a >= 0 && a < W && b >= 0 && b < H){
                if(x[b][a] == '#' && !visited[b][a]){
                    visited[b][a] = true;
                    dfs(a,b);
                }
            }
        }

    }



}