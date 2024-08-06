
import java.lang.*;
import  java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    static int N, M,a[] = {-1,1,0,0}, b[] = {0,0,-1,1};
    static char x[][];

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        x = new char[N][M];

        for(int  i = 0 ;i<N;i++){
            x[i] = br.readLine().toCharArray();
        }

        for(int  i = 0;i<N;i++){
            for(int  j = 0 ;j<M;j++){
                if(x[i][j] == 'W'){
                    if(!check(i,j)){
                        bw.write("0");
                        bw.flush();
                        return;
                    }
                }
            }
        }

        bw.write("1\n");

        for(int  i = 0 ;i<N;i++){
            for(int j = 0; j<M; j++){
                bw.write(String.valueOf(x[i][j]));
            }
            bw.write("\n");
        }
        bw.flush();
    }


    public static boolean check(int i ,int j){
        for(int k = 0;k<4;k++){
            int X = i + a[k];
            int Y = j + b[k];
            if(X < N && X>=0 && Y >= 0 && Y < M){
                if(x[X][Y] == '.'){
                    x[X][Y] = 'D';
                }
                if(x[X][Y] == 'S'){
                    return false;
                }
            }
        }

        return  true;

    }
}