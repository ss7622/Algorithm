import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            long x[] = new long[N];
            long max=0;
            long sum = 0;
            int xf=0;
            for(int j=0;j<N;j++){
                x[j] = sc.nextLong();
            }
            max = x[N-1];
            for(int j=N-2;j>=0;j--){
                if(max > x[j]){
                    sum += max - x[j];
                }
                else{
                    max = x[j];
                }
            }
            System.out.println(sum);
        }
    }
}
