
import java.lang.*;
import  java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    static int N, start, end, relation[][], r, chon=-1;
    static boolean visited[];
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        r = Integer.parseInt(br.readLine());

        relation = new int[r][r];
        visited = new boolean[N+1];

        visited[start] = true;

        for(int i = 0 ;i<r;i++){
            st = new StringTokenizer(br.readLine());

            relation[i][0] = Integer.parseInt(st.nextToken());
            relation[i][1] = Integer.parseInt(st.nextToken());

        }

        dfs(start, 1);

        bw.write(String.valueOf(chon));
        bw.flush();

    }

    public static void dfs(int now, int depth){
        for(int  i = 0 ;i<r;i++){
            if(relation[i][0] == now && !visited[relation[i][1]]){
                if(relation[i][1] == end){
                    chon = depth;
                    return;
                }
                visited[relation[i][1]] = true;
                dfs(relation[i][1], depth+1);
            }

            if(relation[i][1] == now && !visited[relation[i][0]]){
                if(relation[i][0] == end){
                    chon = depth;
                    return;
                }
                visited[relation[i][0]] = true;
                dfs(relation[i][0], depth+1);
            }
        }
    }
}