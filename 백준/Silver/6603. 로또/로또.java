import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int N,selected[];
    static boolean visited[];
    static Map<Integer, Integer> sumv;
    static Boolean selec[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){

            sumv = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            if(N == 0){
                break;
            }

            int x[] = new int[N];
            visited = new boolean[N];
            selected = new int[6];

            for(int  i = 0 ;i<N;i++){
                x[i] = Integer.parseInt(st.nextToken());
                visited[i] = true;
            }

            dfs(x,0,0);

            bw.write("\n");
            bw.flush();

        }

    }

    public static void dfs(int x[], int c,int depth) throws IOException {

        if(depth == 6){
            int s = Arrays.stream(selected).sum();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            for (int i : selected) {
                bw.write(String.valueOf(i));
                bw.write(" ");
            }

            bw.write("\n");
            bw.flush();

            sumv.put(s,0);

            return;
        }

        for(int i = c;  i < N;i++) {
            if(visited[i]) {
                selected[depth] = x[i];
                visited[i] = false;
                dfs(x,i+1,depth + 1);
                visited[i] = true;
            }
        }
    }



}
