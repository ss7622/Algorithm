
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String x[] = new String[9];
        int n[] = new int[9];

        for(int i = 0;i<9;i++){
            x[i] = bf.readLine();
            n[i] = Integer.parseInt(x[i]);
        }
        int i=0,j=0;
        int sum = 0;

        for(i = 0;i<8;i++){
            for(j = i+1;j<9;j++){
                for(int k = 0;k<9;k++){
                    if(k != i && k != j){
                        sum += n[k];
                    }
                }
                if(sum == 100){
                    break;
                }
                sum = 0;
            }
            if(sum == 100){
                break;
            }
        }

        int nan[] = new int[7];
        int flag = 0;

        for(int k=0;k<9;k++){
            if(k != i && k!= j){
                nan[flag++] = n[k];
            }
        }

        Arrays.sort(nan);

        for (int i1 : nan) {
            System.out.println(i1);
        }

    }
}