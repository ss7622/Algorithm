
import java.util.*;
import java.math.*;
import java.lang.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int x[] = new int[a];

        for(int i =0;i <a;i++){
            x[i] = Integer.parseInt(st.nextToken());
        }

        int b = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int x2[] = new int[b];

        for(int i =0;i <b;i++){
            x2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x);

        int cnt = 0;
        Map<Integer,Integer> k = new HashMap<Integer, Integer>();

        for(int i = 0 ;i<a;i++){
            if(i+1 < a && x[i] == x[i+1]){
                cnt++;
            }
            else if(i == a-1 && x[i] != x[i-1]){
                cnt = 1;
                k.put(x[i],cnt);
            }
            else{
                cnt++;
                k.put(x[i],cnt);
                cnt = 0;
            }
        }

        for(int i = 0;i<b;i++){
            if(k.get(x2[i]) == null){
                bw.write("0");
            }
            else {
                bw.write(String.valueOf(k.get(x2[i])));
            }
            bw.write(" ");
        }

        bw.flush();





    }
}