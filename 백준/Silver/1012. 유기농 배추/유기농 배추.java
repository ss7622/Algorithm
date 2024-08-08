import java.lang.*;
import  java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    static int T,X,Y,K,baechu[][], cnt = 0;
    static int x[] = {0,0,0,1,-1}, y[] = {0,1,-1,0,0};

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for(int  i = 0 ;i<T;i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            baechu = new int[Y][X];

            for(int  j = 0 ;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                baechu[b][a] = 1;
            }

            for(int k = 0 ;k<Y;k++){
                for(int j = 0 ;j<X;j++){
                    if(baechu[k][j] == 1){
                        dfs(j,k);
                        cnt++;
                    }
                }
            }
            
            bw.write(cnt + "\n");
            bw.flush();

            cnt = 0;

        }


    }

    public static void dfs(int xx, int yy){

        for(int  i = 0 ;i<5;i++){
            int x1 = xx + x[i];
            int y1 = yy + y[i];
            if(x1 >= 0 && x1 < X && y1 >= 0 && y1 < Y){
                if(baechu[y1][x1] == 1) {
                    baechu[y1][x1] = 0;
                    dfs(x1,y1);
                }
            }
        }
    }

}