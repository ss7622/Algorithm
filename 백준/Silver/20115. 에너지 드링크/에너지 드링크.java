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
        Double x[] = new Double[N];
        String input[] = br.readLine().split(" ");

        double max = 0;
        double sum=0;

        for(int  i = 0;i<N;i++){
            x[i] = Double.parseDouble(input[i]);
            max = Math.max(max,x[i]);
        }

        for (Double l : x) {
            if(l != max){
                sum += l/2;
            }
        }
        
        System.out.println(max + sum);
        
    }
}
