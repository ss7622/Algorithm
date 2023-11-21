import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String input[] = br.readLine().split(" ");
        Long x[] = new Long[N];

        for(int i = 0;i<N;i++){
            x[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(x);

        Long max = 0L;

        if(N %2==1) {
            for (int i = 0, k = N - 2; i < N/2; i++, k--) {
                max = Math.max(max, x[i] + x[k]);
            }
            max = Math.max(max,x[N-1]);
        }

        else{
            for (int i = 0, k = N - 1; i < N/2; i++, k--) {
                max = Math.max(max, x[i] + x[k]);
            }

        }
        System.out.println(max);


    }
}
