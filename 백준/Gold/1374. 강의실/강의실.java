import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long xxx[] = new long[N];
        long start[] = new long[N];
        long end[] = new long[N];
        int flag=0,x=N ;

        for(int i=0;i<N;i++){
            xxx[i] = sc.nextLong();
            start[i] = sc.nextLong();
            end[i] = sc.nextLong();
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                if(end[i] <= start[j]){
                    x--;
                    start[j] = 0;
                    break;
                }
            }
        }

        System.out.println(x);


    }
}
