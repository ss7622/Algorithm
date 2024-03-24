import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int SUM = 100000;
    static int N = 0;
    static int x[][];
    static Boolean exists[][];
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        x = new int[N][N];
        exists = new Boolean[N][N];

        for(int  i = 0 ;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j  = 0 ;j<N;j++){
                x[i][j] = Integer.parseInt(st.nextToken());
                exists[i][j] = true;
            }
        }

        dfs(0,0);
        System.out.println(SUM);

    }

    public static void dfs(int count, int sum){
        if(count == 3){
            SUM = Math.min(sum, SUM);
            return;
        }

        else{
            for(int i = 1;i<N-1;i++){
                for(int j=1;j<N-1;j++){
                    if(isPossible(i,j)) {
                        int tmp_sum = getSum(i, j);
                        setFalse(i,j);

                        dfs(count+1,sum+tmp_sum);
                        setTrue(i,j);
                    }
                }
            }
        }
    }

    public static Boolean isPossible(int i, int j){
        if(exists[i-1][j] && exists[i+1][j] && exists[i][j-1] && exists[i][j+1]){
            return true;
        }
        else{
            return false;
        }
    }

    public static int getSum(int i,int j){
        return x[i][j] + x[i-1][j] + x[i+1][j] + x[i][j-1] + x[i][j+1];
    }

    public static void setFalse(int i, int j){
        exists[i][j] = false;
        exists[i-1][j] = false;
        exists[i+1][j] = false;
        exists[i][j-1] = false;
        exists[i][j+1] = false;
    }
    public static void setTrue(int i, int j){
        exists[i][j] = true;
        exists[i-1][j] = true;
        exists[i+1][j] = true;
        exists[i][j-1] = true;
        exists[i][j+1] = true;
    }
}
