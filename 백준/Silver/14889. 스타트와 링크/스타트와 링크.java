import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int x[][], N, S=0,sum=1000000;
    static Boolean selec[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bf.readLine());

        x = new int[N][N];
        selec = new Boolean[N];

        for(int i = 0;i<N;i++) {
            selec[i] = false;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                x[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        bw.write(String.valueOf(sum));
        bw.flush();

    }

    public static void dfs(int num, int flag){
        if(num == (N/2)){
            int extrue = 0, exfalse=0;
            for(int i = 0 ;i<N;i++){
                for(int j = 0 ;j<N;j++){
                    if(selec[j] && selec[i]){
                        extrue += x[i][j];
                    }
                    if(!selec[i] && !selec[j]){
                        exfalse += x[i][j];
                    }
                }
            }

            sum = Math.min(sum, Math.abs(exfalse - extrue));

            return;
        }
        for(int i=flag;i<N;i++){
            if(!selec[i]) {
                selec[i] = true;
                dfs(num + 1, i+1);
                selec[i] = false;
            }
        }
    }
}