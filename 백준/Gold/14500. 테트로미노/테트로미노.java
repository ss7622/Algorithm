import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.StringTokenizer;

public class Main {
    static int max = 0, x,y;
    static int[][] square;
    static boolean visit[][];
    static int before[] = new int[2];
    static int[] findx = {0,0,1,-1}, findy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        square = new int[x][y];
        visit = new boolean[x][y];

        for(int  i =0;i<x;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<y;j++){
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(!visit[i][j]){
                    visit[i][j] = true;
                    dfs(1,square[i][j],i,j,i,j);
                }
            }
        }
        System.out.println(max);
    }

    public static void dfs(int depth, int sum, int i, int j, int bi,int bj){
        if(depth == 4){
            max = Math.max(max,sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int xx = i + findx[k];
            int yy = j + findy[k];
            int xx1 = bi + findx[k];
            int yy1 = bj + findy[k];
            if (xx >= 0 && xx < x && yy >= 0 && yy < y && !visit[xx][yy]) {
                visit[xx][yy] = true;
                dfs(depth + 1, sum + square[xx][yy], xx, yy,i,j);
                visit[xx][yy] = false;
            }
            if (xx1 >= 0 && xx1 < x && yy1 >= 0 && yy1 < y && !visit[xx1][yy1]) {
                visit[xx1][yy1] = true;
                dfs(depth + 1, sum + square[xx1][yy1], xx1, yy1,i,j);
                visit[xx1][yy1] = false;
            }
        }
    }
}