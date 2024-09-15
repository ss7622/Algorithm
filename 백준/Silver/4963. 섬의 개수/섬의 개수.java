import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int W=1,H=1,island[][], x[] = {0,0,1,-1,1,1,-1,-1}, y[] = {1,-1,0,0,1,-1,1,-1};
    static boolean visited[][];
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(W != 0 && H != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            island = new int[H][W];
            visited = new boolean[H][W];

            for(int  i = 0;i<H;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j<W;j++){
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for(int  i = 0 ;i<H;i++){
                for(int  j = 0 ;j<W;j++){
                    if(island[i][j] == 1 && !visited[i][j]){
                        visited[i][j] = true;
                        dfs(j,i);
                        cnt++;
                    }
                }
            }
            if(W != 0 && H != 0) {
                bw.write(cnt + "\n");
            }
        }
        bw.flush();
    }

    static void dfs(int xnow, int ynow){
        for(int  i = 0 ;i<8;i++){
            int xx = xnow + x[i];
            int yy = ynow + y[i];
            if(xx >= 0 && xx < W && yy >= 0 && yy < H &&
                    island[yy][xx] == 1 && !visited[yy][xx]){
                visited[yy][xx] = true;
                dfs(xx,yy);
            }
        }
    }
}