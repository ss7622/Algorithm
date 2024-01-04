
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String x[];

        String line = br.readLine();
        x = line.split(" ");

        int N=0,cnt=0;


        for(int  i = 0 ;i<2;i++){
            if(i == 0) {
                N = Integer.parseInt(x[i]);
            }
            else{
                cnt = Integer.parseInt(x[i]);
            }
        }

        int cnt1=0;

        for(int i =1;i<=N;i++){
            if(N % i == 0){
                cnt1++;
            }
            if(cnt1 == cnt){
                System.out.print(i);
                break;
            }
        }
        if(cnt1 < cnt){
            System.out.println("0");
        }
    }
}