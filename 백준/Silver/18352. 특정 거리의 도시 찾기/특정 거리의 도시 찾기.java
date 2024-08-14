import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N,M,K,S;
    static boolean visited[], result[];
    static List<ArrayList<Integer>> edge = new ArrayList<>();

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        result = new boolean[N+1];

        for(int  i = 0 ;i<=N;i++){
            edge.add(new ArrayList<>());
        }

        for(int  i = 0 ;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edge.get(a).add(b);
        }

        visited[S] = true;

        ArrayList<Integer> ed = new ArrayList<>();
        ed.add(S);

        bfs(0,ed);

        int flag = 0;

        for(int  i =1;i<=N;i++){
            if(result[i]){
                bw.write(i+ "\n");
                flag = 1;
            }
        }

        if(flag == 0){
            bw.write("-1");
        }

        bw.flush();


    }

    public static void bfs(int depth, ArrayList<Integer> ed) throws IOException {

        if(depth == K){
            for (Integer i : ed) {
                result[i] = true;
            }
            return;
        }

        ArrayList<Integer> edd = new ArrayList<>();

        while(!ed.isEmpty()){
            Integer k = ed.get(0);
            for(int  i = 0;i<edge.get(k).size();i++){
                int re = edge.get(k).get(i);
                if(!visited[re]){
                    visited[re] = true;
                    edd.add(re);
                }
            }
            ed.remove(0);
        }

        bfs(depth+1,edd);

    }



}