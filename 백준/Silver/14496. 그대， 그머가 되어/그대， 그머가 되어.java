import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int start,end, N,M,cnt = -1;
    static boolean visited[];
    static List<ArrayList<int []>> edge = new ArrayList<>();


    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0 ;i<=N;i++){
            edge.add(new ArrayList<int []>());
        }

        visited = new boolean[N+1];

        for(int  i = 1 ;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge.get(a).add(new int[]{b, 0});
            edge.get(b).add(new int[]{a, 0});

        }

        if(start == end){
            bw.write("0");
            bw.flush();
            return;
        }

        bfs();

        bw.write(String.valueOf(cnt));
        bw.flush();

    }

    public static void bfs(){

        ArrayList<int[]> ed = new ArrayList<>();

        ed.add(new int[] {start,0});

        visited[start] = true;

        while (!ed.isEmpty()){
            for(int  i = 0 ;i<edge.get(ed.get(0)[0]).size();i++){
                int k = edge.get(ed.get(0)[0]).get(i)[0];

                if(k == end){
                    cnt = ed.get(0)[1] + 1;
                    return;
                }

                if(!visited[k]){
                    visited[k] = true;
                    ed.add(new int[] {k,ed.get(0)[1]+1});
                }
            }
            ed.remove(0);
        }
    }



}