import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        String[] inputs;

        for(int i = 0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int jiwon[][] = new int[N][2];
            int cnt = 1;
            for(int j = 0 ;j<N;j++) {
                inputs = br.readLine().split(" ");

                jiwon[j][0] = Integer.parseInt(inputs[0]);
                jiwon[j][1] = Integer.parseInt(inputs[1]);
            }
            Arrays.sort(jiwon, (o1,o2) -> {
                return o1[0] - o2[0];
            });

            int min = jiwon[0][1];
            for(int j = 1 ;j<N;j++){

                if(min > jiwon[j][1]){
                    cnt++;
                    min = jiwon[j][1];
                }
            }
            System.out.println(cnt);

        }



    }
}
