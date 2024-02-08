
import java.util.*;
import java.math.*;
import java.lang.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] x = bf.readLine().split(" ");

        char a[] = x[0].toCharArray();
        char b[] = x[1].toCharArray();

        int alen = a.length;
        int blen = b.length;
        int min = 51;
        int cnt = 0;
        int flag = 0;

        for(int i=0;i<blen;i++){
            for(int k=0,j=i;j<i+alen && i+alen <= blen;k++,j++){
                if(b[j] != a[k]){
                    cnt++;
                }
                flag = 0;
            }
            if(flag == 0){
                min = Math.min(min,cnt);
                cnt = 0;
                flag = 1;
            }
        }

        System.out.print(min);

    }
}