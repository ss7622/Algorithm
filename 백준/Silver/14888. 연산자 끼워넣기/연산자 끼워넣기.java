import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int cnt=0, N, x[], four[] = new int[4], selec[];
    static long min = 1000000000L,max = -1000000000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        x = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int  i = 0 ;i<N;i++){
            x[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        selec = new int[N-1];

        for(int  i = 0 ;i<4;i++){
            four[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        bw.write(String.valueOf(max));
        bw.write("\n");
        bw.write(String.valueOf(min));

        bw.flush();


    }

    public static void dfs(int depth){
        if(depth == N-1){
            long s = sum();
            if(min > s){
                min = s;
            }
            if(max < s){
                max = s;
            }
            return;
        }

        for(int  i = 0 ;i<4;i++){
            if(four[i] != 0){
                four[i] -= 1;
                selec[depth] = i;
                dfs(depth+1);
                four[i] += 1;
            }
        }
    }

    public static long sum(){

        int c[] = Arrays.copyOf(x,x.length);

        for(int  i = 0 ;i<N-1;i++){
            if(selec[i] == 0){
                c[i+1] = c[i] + c[i+1];
            }
            if(selec[i] == 1){
                c[i+1] = c[i] - c[i+1];
            }
            if(selec[i] == 2){
                c[i+1] = c[i] * c[i+1];
            }
            if(selec[i] == 3){
                c[i+1] = c[i] / c[i+1];
            }
        }

        return c[N-1];
    }


}
