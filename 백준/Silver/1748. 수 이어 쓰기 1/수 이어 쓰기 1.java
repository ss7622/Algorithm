import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int count = 0;
        int  i = 10;
        int mul = 9;
        int ad = 1;

        for(i=10;i<=x;i *= 10){
            count += mul * ad;
            mul *= 10;
            ad++;
        }

        i /= 10;

        for(;i<=x;i++){
            count += ad;
        }

        System.out.println(count);
    }
}