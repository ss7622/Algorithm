import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,cnt=0, x[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        x = new int[N][N];

        for(int  i=0 ;i<N;i++){
            char[] a = br.readLine().toCharArray();
            for(int  j = 0 ;j<N;j++){
                x[i][j] = Integer.parseInt(String.valueOf(a[j]));
            }
        }

        devide(0,N,0,N,N);

        bw.flush();

    }

    public static void devide(int left, int right, int up, int down, int n) throws IOException {
        int s = sum(left, right, up, down);
        if(s == 0){
            bw.write("0");
            return;
        }
        if(s == n*n){
            bw.write("1");
            return;
        }
        if(n == 2){
            bw.write("(");
            for(int  i = up;i<down;i++){
                for(int j=left;j<right;j++){
                    bw.write(String.valueOf(x[i][j]));
                }
            }
            bw.write(")");
            return;
        }
        bw.write("(");
        devide(left,(right+left)/2,up,(down+up)/2,n/2);
        devide((left+right)/2,right,up,(down+up)/2,n/2);
        devide(left,(right+left)/2,(down+up)/2,down,n/2);
        devide((left+right)/2,right,(down+up)/2,down,n/2);
        bw.write(")");


    }

    public static int sum(int left, int right, int up, int down){
        int s = 0;
        for(int i = up; i<down;i++){
            for(int j = left;j<right;j++){
                s += x[i][j];
            }
        }

        return s;
    }

}
