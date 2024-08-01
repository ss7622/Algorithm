import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int jubsi, chobab, conti, c,max = 0, selec[],x[],cnt = 1;

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

        int start = 0, end = conti;

        selec[c]++;

        for(int  i = start ;i<end;i++){
            if(selec[x[i]] == 0){
                cnt++;
            }
            selec[x[i]]++;
        }

        max =  Math.max(max ,cnt);

        for(int  i =end;i<jubsi+conti-1;i++){
            selec[x[start]]--;
            
            if(selec[x[start]] == 0){
                cnt--;
            }


            if(selec[x[i % jubsi]] == 0){
                cnt++;
            }
            selec[x[i%jubsi]]++;

            max =  Math.max(max ,cnt);

            start++;

        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

}
