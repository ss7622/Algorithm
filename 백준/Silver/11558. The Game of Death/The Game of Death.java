
import java.io.*;
import java.math.*;
import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N  =  Integer.parseInt(br.readLine());

        for(int  i = 0 ;i<N;i++){
            int person = Integer.parseInt(br.readLine());
            
            if(person == 1){
                bw.write("1\n");
                bw.flush();
                continue;
            }
            int x[] = new int[person];
            for(int  j =0 ;j<person;j++){
                x[j] = Integer.parseInt(br.readLine());
            }

            List<Integer> n = new ArrayList<Integer>();
            int k = 0;
            int cnt = 0;
            while(true){
                n.add(k);
                if(n.contains(x[k]-1)){
                    bw.write("0\n");
                    bw.flush();
                    break;
                }

                if(x[k] == person){
                    cnt++;
                    bw.write(String.valueOf(cnt));
                    bw.write("\n");
                    bw.flush();
                    break;
                }
                cnt++;
                k = x[k]-1;
            }
        }
    }
}