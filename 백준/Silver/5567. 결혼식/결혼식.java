import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M,cnt=0;
    static boolean visited[];
    static List<ArrayList<int []>> edge = new ArrayList<>();

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];

        for(int i =0;i<=N;i++){
            edge.add(new ArrayList<>());
        }

        for(int i = 0 ;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());

            edge.get(a).add(new int[] {b,0});
            edge.get(b).add(new int[] {a,0});

        }

        bfs();

        bw.write(String.valueOf(cnt));
        bw.flush();


    }

    public static void bfs(){
        ArrayList<int[]> ed = new ArrayList<>();

        ed.add(new int[] {1,0});
        visited[1] = true;

        while(!ed.isEmpty()){
            for(int  i = 0 ;i<edge.get(ed.get(0)[0]).size();i++){

                int k = edge.get(ed.get(0)[0]).get(i)[0];
                int depth = ed.get(0)[1];


                if(0 <= depth &&  depth <= 1 && !visited[k]){
                    cnt++;
                }

                if(!visited[k]){
                    visited[k] = true;
                    ed.add(new int[] {k,depth+1});
                }
            }
            ed.remove(0);
        }
    }



}