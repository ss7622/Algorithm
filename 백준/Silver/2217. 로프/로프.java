
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int lope[] = new int[N];
        int x=0;
        for(int i=0;i<N;i++){
            lope[i] = sc.nextInt();
        }

        Arrays.sort(lope);

        for(int i=0;i<N;i++){
            x = Math.max(x,lope[i]*(N-i));
        }

        System.out.println(x);




    }
}
