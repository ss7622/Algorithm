import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int N, x[], budung[], smin[], smax[];
    static long min = 9999999999L, max = -9999999999L;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        budung = new int[N];
        int selec[] = new int[N+1];
        smin = new int[N+1];
        smax = new int[N+1];

        for(int i = 0 ;i<N;i++){
            if(Objects.equals(st.nextToken(), ">")){
                budung[i] = 1;
            }
            else{
                budung[i] = 2;
            }
        }

        x = new int[10];
        visited = new boolean[10];

        for(int i = 0 ;i<10;i++){
            x[i] = i;
            visited[i] = true;
        }

        dfs(0,selec);

        for (int i : smax) {
            bw.write(String.valueOf(i));
        }
        bw.write("\n");
        for (int i : smin) {
            bw.write(String.valueOf(i));
        }
        bw.flush();

    }

    public static void dfs(int depth, int selec[]) throws IOException {
        if(depth == N+1){
            if(ganung(selec)) {
                long s = sum(selec);
                if (min > s) {
                    min = s;
                    smin = Arrays.copyOf(selec,N+1);
                }
                if (max < s) {
                    max = s;
                    smax = Arrays.copyOf(selec,N+1);
                }
            }
            
            return;
        }

        for(int i = 0 ;i<10;i++){
            if(visited[i]){
                selec[depth] = x[i];
                visited[i] = false;
                dfs(depth+1, selec);
                visited[i] = true;
            }
        }

    }
    
    public static long sum(int selec[]){
        String s = "";
        
        for(int i = 0 ;i<selec.length;i++){
            s += selec[i];
        }
        
        return Long.parseLong(s);
    }

    public static boolean ganung(int x[]){
        for(int i = 0 ;i<x.length-1;i++){

            if(budung[i] == 1){
                if(x[i] < x[i+1]){return false;}
            }
            if(budung[i] == 2){
                if(x[i] > x[i+1]){return false;}
            }
        }

        return true;
    }


}
