import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int jubsi, chobab, conti, c,max = 0, selec[],x[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        jubsi = Integer.parseInt(st.nextToken());
        chobab = Integer.parseInt(st.nextToken());
        conti = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        x = new int[jubsi];
        selec = new int[chobab+1];

        for(int  i =0 ;i<jubsi;i++){
            x[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0 ;i<chobab+1;i++){
            selec[i] = 300001;
        }

        dfs();

        bw.write(String.valueOf(max));
        bw.flush();
    }

    public static void dfs(){

        for(int  i = 0; i<jubsi;i++){
            int cnt = 0, flag= 0;

            for(int j = i; j < i+conti;j++){
                if(selec[x[j % jubsi]] != i){
                    cnt++;
                }
                selec[x[j % jubsi]] = i;

                if(x[j % jubsi] == c){
                    flag = 1;
                }

            }

            if(flag != 1){
                cnt++;
            }

            max = Math.max(max,cnt);


        }

    }

}
