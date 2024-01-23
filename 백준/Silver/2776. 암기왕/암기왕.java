
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, String> x;


        int T = Integer.parseInt(bf.readLine());

        for(int k = 0;k<T;k++) {
            x = new HashMap<String, String>(1000000);

            int N = Integer.parseInt(bf.readLine());
            String in;

            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int i = 0; i < N; i++) {
                in = st.nextToken();
                x.put(in, in);
            }

            N = Integer.parseInt(bf.readLine());

            st = new StringTokenizer(bf.readLine());

            for (int i = 0; i < N; i++) {
                in = st.nextToken();
                if (x.get(in) == (null)) {
                    bw.write("0\n");
                } else {
                    bw.write("1\n");
                }
            }
            bw.flush();
        }
    }
}