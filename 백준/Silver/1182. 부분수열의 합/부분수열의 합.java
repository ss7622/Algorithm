import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int x[], N, S=0,cnt=0;
    static Boolean selec[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        x = new int[N];
        selec = new Boolean[N];
        st = new StringTokenizer(bf.readLine());

        for(int i = 0 ;i<N;i++){
            x[i] = Integer.parseInt(st.nextToken());
            selec[i] = true;
        }

        dfs(0,0);

        bw.write(String.valueOf(cnt));
        bw.flush();

    }

    public static void dfs(int exsum,int flag){
        if(exsum == S && flag > 0){
            cnt++;
        }
        for(int i = flag ;i<N;i++){
            if(selec[i]){
                Select(i);
                dfs(exsum + x[i],i+1);
                unSelect(i);
            }
        }
    }

    public static void Select(int i){
        selec[i] = false;
    }
    public static void unSelect(int i){
        selec[i] = true;
    }
}