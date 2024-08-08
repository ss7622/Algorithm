
import java.lang.*;
import  java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    static int N;
    static String x[];

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        x = new String[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int  i = 0 ;i<N;i++){
            x[i] = st.nextToken();
        }

        Arrays.sort(x,new Comparator<String>(){
            @Override
            public int compare(String a, String b){

                return (b+a).compareTo(a+b);
            }
        });

        if(x[0].equals("0")){
            bw.write("0");
            bw.flush();
            return;
        }

        for (String s : x) {
            bw.write(s);
        }
        bw.flush();

    }



}