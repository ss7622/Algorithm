import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main{
    static int N, max = 0, selec[];
    static char[] x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int  i = N;
        if(N == 1){
            bw.write("2");
            bw.flush();
            return;
        }
        while(true){

            String a= String.valueOf(i);

            x = a.toCharArray();

            if(pael(x,0,x.length-1)){
                if(sosu(i)) {
                    bw.write(a);
                    bw.flush();
                    break;
                }
            }

            i++;

        }

    }

    static public boolean sosu(int k){
        for(int i = 2 ;i<=Math.sqrt(k);i++){
            if(k % i == 0){
                return false;
            }
        }
        return  true;
    }

    static public boolean pael(char[] k, int left, int right){
        for(int  i = 0 ; i<k.length/2;i++) {
            if (k[i] != k[k.length-1-i]) {
                return false;
            }
        }


        return true;
    }

}
