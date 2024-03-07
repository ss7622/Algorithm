
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String args[])throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char x[][] = new char[N][N];

        for(int  i = 0;i<N;i++){
            x[i] = bf.readLine().toCharArray();
        }

        int max = 0;

        for(int  i=0;i<N;i++){
            for(int  j = 0 ;j<N-1;j++){
                if(x[i][j] != x[i][j+1]){
                    swap(x,i,j,1);
                    max = Math.max(max,search(x,N));
                    swap(x,i,j,1);
                }
            }
        }

        for(int  i=0;i<N;i++){
            for(int  j = 0 ;j<N-1;j++){
                if(x[j][i] != x[j+1][i]){
                    swap(x,j,i,2);
                    max = Math.max(max,search(x,N));
                    swap(x,j,i,2);
                }
            }
        }

        System.out.println(max);


    }

    public static char[][] swap(char x[][],int a,int b,int c){
        if(c == 1) {
            char y = x[a][b];
            x[a][b] = x[a][b + 1];
            x[a][b + 1] = y;
        }
        if(c == 2){
            char y = x[a][b];
            x[a][b] = x[a+1][b];
            x[a+1][b] = y;
        }

        return x;

    }

    public static int search(char x[][],int N){
        int cnt = 1;
        int max = 0;
        for(int i = 0;i<N;i++){
            for(int j = 0 ;j<N-1;j++){
                if(x[i][j] == x[i][j+1]){
                    cnt++;
                }
                if(x[i][j] != x[i][j+1]){
                    max = Math.max(cnt, max);
                    cnt = 1;
                }
            }
            max = Math.max(cnt, max);
            cnt = 1;

        }
        max = Math.max(cnt, max);

        for(int i = 0;i<N;i++){
            for(int j = 0 ;j<N-1;j++){
                if(x[j][i] == x[j+1][i]){
                    cnt++;
                }
                if(x[j][i] != x[j+1][i]){
                    max = Math.max(cnt, max);
                    cnt = 1;
                }
            }
            max = Math.max(cnt, max);
            cnt = 1;
        }

        return max;
    }
}
