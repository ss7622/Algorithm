import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int sum=0, N, M,x[], start=0, min =2147482900;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        x = new int[N];

        int s = 0;
        int m = 0;
        for(int i = 0 ;i<N;i++){
            x[i] = Integer.parseInt(st.nextToken());
            s += x[i];
            m = Math.max(m,x[i]);
        }

        start = s/M;
        
        if(start < m){
            start = m;
        }

        dfs(start);

        bw.write(String.valueOf(min));
        bw.flush();

    }

    public static void dfs(int depth){

        int cnt = 0;
        int flag = 0;
        sum = 0;

        for(int i=0;i<N;i++){
            sum += x[i];
            if(sum > depth){
                cnt++;
                sum = x[i];
            }

            if(cnt == M){
                dfs(depth+1);
                flag = 1;
                break;
            }
        }

        if(flag == 0) {
            if (min > depth) {
                min = depth;
            }
        }

    }

}
