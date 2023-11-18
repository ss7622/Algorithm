import java.util.Scanner;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();

        long start[] = new long[N];
        long end[] = new long[N];

        for(int i= 0 ;i<N;i++){
            start[i] = sc.nextLong();
            end[i] = sc.nextLong();
        }

        Arrays.sort(start);
        Arrays.sort(end);
        long s;
        long e;
        int cnt = 0;
        int  k = 0;
        for(int i = 0;i<N;i++){
            s = start[i];
            e = end[i]-1;
            if(e < s){
                continue;
            }
            if(i < N-1 && end[i] == start[i+1]){
                e = end[i+1]-1;
                k = i+1;
                for(int j=i+1; j<N-1; j++){
                    if(end[j] == start[j+1]) {
                        e = end[j + 1]-1;
                        k = j+1;
                    }
                }
                i = k;
            }
            if((e - s+1) % L == 0){
                cnt += (e-s+1) / L;
            }
            else{
                cnt += (e-s) /L+1;
                for(int j = i+1;j<N;j++){
                    if(start[j] < s + ((e-s)/L+1) * L){
                        start[j] =  s + ((e-s)/L+1) * L;
                        i = j-1;
                    }
                }
            }
        }

        System.out.println(cnt);

    }
}
