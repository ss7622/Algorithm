
import java.lang.*;
import  java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    static int N,M,V,edge[][];
    static boolean visited[];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        edge = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0 ;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edge[a][b] = 1;
            edge[b][a] = 1;
        }


        bw.write(String.valueOf(V));
        visited[V] = true;
        dfs(V);
        bw.write("\n");
        bw.flush();

        visited = new boolean[N+1];
        visited[V] = true;

        List<Integer> n = new ArrayList<>();
        bw.write(String.valueOf(V));
        n.add(V);
        bfs(n);
        bw.flush();




    }



    public static void dfs(int ob) throws IOException {
        for(int  i = 1 ;i<=N;i++){
            if(edge[ob][i] == 1 && !visited[i]){
                visited[i] = true;
                bw.write(" " + i);
                dfs(i);
            }
        }
    }

    public static void bfs(List<Integer> next) throws IOException {
        List<Integer> n = new ArrayList<>();
        while(!next.isEmpty()){
            for(int  i =1 ;i<=N;i++){
                if(edge[next.get(0)][i] == 1 && !visited[i]){
                    visited[i] = true;
                    bw.write(" " + i);
                    n.add(i);
                }
            }
            next.remove(0);
        }
        if(!n.isEmpty()) {
            bfs(n);
        }
    }
}