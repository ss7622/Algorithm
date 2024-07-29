import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int R,C,K,cnt=0;
    static char x[][];
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        x = new char[R][C];
        visited = new boolean[R][C];

        for(int  i = 0 ;i<R;i++){
            char in[] = br.readLine().toCharArray();
            for(int j = 0 ;j<C;j++){
                x[i][j] = in[j];
                visited[i][j] = true;
            }
        }
        visited[R-1][0] = false;
        dfs(1,R-1,0);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    public static void dfs(int depth, int Y, int X){
        if(Y == 0 && X == C-1){
            if(depth == K){
                cnt++;
            }
            return;
        }

        if(depth == K){
            return;
        }

        if(Y > 0 && x[Y-1][X] != 'T' && visited[Y-1][X]){
            visited[Y-1][X] = false;
            dfs(depth+1, Y-1,X);
            visited[Y-1][X] = true;
        }
        if(X < C-1 && x[Y][X+1] != 'T' && visited[Y][X+1]){
            visited[Y][X+1] = false;
            dfs(depth+1,Y,X+1);
            visited[Y][X+1] = true;
        }
        if(Y < R-1 && x[Y+1][X] != 'T' && visited[Y+1][X]){
            visited[Y+1][X] = false;
            dfs(depth+1,Y+1,X);
            visited[Y+1][X] = true;
        }
        if(X > 0 && x[Y][X-1] != 'T' && visited[Y][X-1]){
            visited[Y][X-1] = false;
            dfs(depth+1,Y,X-1);
            visited[Y][X-1] = true;
        }


    }


}
