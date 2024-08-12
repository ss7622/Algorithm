import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, start = 0;
    static boolean visited[];
    static List<ArrayList<Integer>> edge = new ArrayList<>();

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for(int  i = 0 ;i<=N;i++){
            edge.add(new ArrayList<Integer>());
        }

        visited = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =1;i<=N;i++){
            int a = Integer.parseInt(st.nextToken());

            if((i - a) > 0){
                edge.get(i).add(i-a);
            }
            if((i+a) <= N){
                edge.get(i).add(i+a);
            }
        }

        start = Integer.parseInt(br.readLine());
        visited[start] = true;

        dfs(start);

        int cnt = 0;

        for (boolean b : visited) {
            if(b){
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    public static void dfs(int now) {
        while(!edge.get(now).isEmpty()){
            int re = edge.get(now).get(0);
            if(!visited[re]){
                visited[re] = true;
                dfs(re);
            }
            edge.get(now).remove(0);
        }
    }



}