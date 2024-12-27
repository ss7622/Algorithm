import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] t;
    static int[] p;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        t = new int[N];
        p = new int[N];
        
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0,0);

        System.out.println(max);

    }

    static void dfs(int beforeStart, int start, int sum){
        if(start > N){
            sum -= p[beforeStart];
        }
        if(start >= N){
            max = Math.max(max, sum);
            return;
        }

        for(int i=start;i<N;i++){
            dfs(i, i+t[i], sum+p[i]);
        }
    }
}