
import java.lang.*;
import java.math.*;
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int x[] = new int[3];
        int xflag = 0;

        if(N < 100){
            System.out.println(N);

            return;
        }

        int k = N;

        int cnt = 99;

        for(int i=100;i<=N;i++){
            k = i;
            for(int  j = 100;j>0;j/=10){
                x[xflag++] = k/j;
                k %= j;
            }
            if(x[0] - x[1] == x[1] - x[2]){
                cnt++;
            }
            xflag = 0;
        }

        System.out.println(cnt);

    }
}