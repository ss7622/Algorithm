import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int sum=0, N, M,x[], min =2147000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        x = new int[N];

        int s = 0, m=0;

        for(int i = 0 ;i<N;i++){
            x[i] = Integer.parseInt(st.nextToken());
            s += x[i];
            m = Math.max(m,x[i]);
        }

        binary(m,s+1);

        bw.write(String.valueOf(min));
        bw.flush();

    }

    public static void binary(int left,int right){
        int mid  = (left + right) / 2;

        if(left >= right){
            return;
        }

        int s = 0, cnt = 1;

        for(int  i = 0;i<N;i++){
            s += x[i];

            if(s > mid){
                cnt++;
                s = x[i];
            }
        }
        if(cnt <= M){
            binary(left, mid);
        }
        if(cnt > M){
            binary(mid+1, right);
        }

        if(cnt <= M){
            min = Math.min(min, mid);
        }

    }

}
