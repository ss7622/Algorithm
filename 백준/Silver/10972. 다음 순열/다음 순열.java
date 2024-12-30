import static java.lang.System.exit;

import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] x;
    static int[] sorted;
    static int flag = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       N = Integer.parseInt(br.readLine());
       StringTokenizer st = new StringTokenizer(br.readLine());
       x = new int[N];
       sorted = new int[N];
       visited = new boolean[N];
       for (int i = 0; i < N; i++) {
           x[i] = Integer.parseInt(st.nextToken());
           sorted[i] = i+1;
       }
       dfs(new int[N], 0, x[0]-1);
       System.out.println("-1");
    }

    public static void dfs(int[] re, int depth, int start){
        if(depth == N){
            if(flag == 1){
                for (int i : re) {
                    System.out.print(i + " ");
                }
                exit(0);
            }
            if(check(re) && flag == 0){
                flag = 1;
            }
            return;
        }

        for(int i=start;i<N;i++){
            if(!visited[i]){
                re[depth] = sorted[i];
                visited[i] = true;
                if(depth < N-1 && flag == 0) {
                    dfs(re, depth + 1, x[depth + 1] - 1);
                }
                else{
                    dfs(re, depth + 1, 0);
                }
                visited[i] = false;
            }
        }
    }

    public static boolean check(int[] re){
        for(int i = 0; i < N; i++){
            if(re[i] != x[i]){
                return false;
            }
        }
        return true;
    }
}