import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int chai[], N,cnt=0, yual[], hap[], hang[];
    static Boolean selec[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();
        N = Integer.parseInt(num);

        chai = new int[N];
        yual = new int[N];
        hap = new int[N];
        hang = new int[N];

        dfs(0,0,0);

        bw.write(String.valueOf(cnt));
        bw.flush();

    }

    public static void dfs(int x, int y, int fcnt){
        int iy = y;
            for(int jx = 0 ;jx <N;jx++){
                if(ganung(jx,iy,fcnt)){
                    yual[fcnt] = iy;
                    hap[fcnt] = iy + jx;
                    hang[fcnt] = jx;
                    if(fcnt == N-1){
                        cnt++;
                        return;
                    }
                    dfs(jx,iy+1,fcnt+1);
                }
            }
        

    }

    public static boolean ganung(int x, int y, int fcnt){
        for(int  i =0;i<fcnt;i++){
            if(y == yual[i]){
                return false;
            }
            if(Math.abs(yual[i] - y) == Math.abs(hang[i] - x)){
                return false;
            }

            if(hap[i] == x+y){
                return false;
            }
            if(hang[i] == x){
                return false;
            }
        }

        return true;
    }


}
