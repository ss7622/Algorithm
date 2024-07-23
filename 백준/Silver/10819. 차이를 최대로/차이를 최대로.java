import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int N,max=0,original[];
    static Boolean selec[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();
        N = Integer.parseInt(num);

        int a;

        original = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int  i = 0 ;i<N;i++){
            original[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        bw.write(String.valueOf(max));
        bw.flush();

    }

    public static void dfs(int k){
        if(sum(original) > max){
            max = sum(original);
        }
        for(int j = k;j<N-1;j++) {
            for (int i = 0; i < N - 1; i++) {
                swap(original, i);
                dfs(j + 1);
            }
        }

    }

    public static int sum(int x[]){
        int s = 0;

        for(int i = 0 ;i<N-1;i++){
            s += Math.abs(x[i] - x[i+1]);
        }

        return s;
    }

    public static void swap(int x[], int k){
        int flag = 0;
        flag = x[k];
        x[k] = x[k+1];
        x[k+1] = flag;
    }


}
