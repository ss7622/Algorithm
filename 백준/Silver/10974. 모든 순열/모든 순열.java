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
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        dfs(0, new int[N]);
    }

    public static void dfs(int depth, int[] x){
        if(depth == N){
            for(int i = 0 ; i < N ; i++){
                System.out.print(x[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!visited[i]) {
                visited[i] = true;
                x[depth] = i;
                dfs(depth + 1, x);
                visited[i] = false;
            }
        }
    }

}