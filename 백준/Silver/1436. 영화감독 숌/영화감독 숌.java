
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Main{
    public static void main(String args[])throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int sum = 666;
        int cnt = 0;

        while(cnt != N){
            String k = Integer.toString(sum);
            char x[] = k.toCharArray();

            for(int i = 0 ; i<x.length-2;i++){
                if(x[i] == '6' && x[i+1] == '6' && x[i+2] == '6'){
                    cnt++;
                    break;
                }
            }
            sum++;
        }

        System.out.println(sum-1);




    }
}