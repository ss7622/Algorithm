import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> remainder = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int  i = 0;i<T;i++){
            remainder = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int to = least_multiple(a,b);

            int flag = 0;

            for(int j=x;j<=to;j+=a){
                if((j-y) % b == 0){
                    System.out.println(j);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                System.out.println(-1);
            }
        }
    }

    public static int least_multiple(int a, int b){
        int min = Math.min(a,b);

        for(int i=2;i<=min;i++){
            if(a%i==0 && b%i==0){
                remainder.add(i);
                a /= i;
                b /= i;
                i = 2;
            }
        }
        int result = a * b;
        for (Integer i : remainder) {
            result *= i;
        }
        return result;
    }
}