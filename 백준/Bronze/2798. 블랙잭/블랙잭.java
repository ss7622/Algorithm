
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int x[] = new int[N];

        for(int i=0;i<N;i++){
            x[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(x);

        int sum = 0;

        for(int i = 0;i<N-2;i++){
            for(int j = i+1 ;j<N;j++){
                for(int k = j+1;k<N;k++){
                    if(x[i] + x[j] + x[k] > M){
                        continue;
                    }
                    else{
                        sum = Math.max(sum, x[i]+x[j]+x[k]);
                    }
                }
            }
        }

        System.out.println(sum);
        
    }
}