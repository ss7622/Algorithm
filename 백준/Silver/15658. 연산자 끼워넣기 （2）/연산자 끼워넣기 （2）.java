import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int N,cnt[],act[];
    static long max = -1000000000L, min = 1000000000L,original[];
    static Boolean selec[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();
        N = Integer.parseInt(num);

        int a;

        original = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int  i = 0 ;i<N;i++){
            original[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        cnt = new int[4];

        for(int  i = 0 ;i<4;i++){
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        act = new int[N-1];


        dfs(0);

        bw.write(String.valueOf(max));
        bw.write("\n");
        bw.write(String.valueOf(min));

        bw.flush();

    }

    public static void dfs(int depth){

        if(depth == N-1){
            
            long s = sum(original,act);

            if(max < s){
                max = s;
            }
            if(min> s){
                min = s;
            }

            return;
        }

        for(int  i = 0;i<4;i++){
            if(cnt[i] > 0){
                act[depth] = i+1;
                cnt[i] = cnt[i]-1;
                dfs(depth+1);
                cnt[i] = cnt[i]+1;
            }
        }
    }

    public static long sum(long x[], int flag[]){

        long[] re = Arrays.copyOf(x,x.length);

        for(int  i = 0 ;i<N-1;i++){
            //더하기
            if(flag[i] == 1){
                re[i+1] = re[i] + re[i+1];
            }
            //빼기
            else if(flag[i] == 2){
                re[i+1] = re[i] - re[i+1];
            }
            //곱하기
            else if(flag[i] == 3){
                re[i+1] = re[i] * re[i+1];
            }
            else{
                re[i+1] = re[i] / re[i+1];
            }
        }

        return re[N-1];
    }


}
