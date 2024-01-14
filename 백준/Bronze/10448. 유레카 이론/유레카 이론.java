
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        String s[] = new String[n];
        int x[] = new int[n];

        for(int i = 0 ;i<n;i++){
            s[i] = bf.readLine();
            x[i] = Integer.parseInt(s[i]);
        }

        int flag = 0;

        for(int i = 0 ;i<n;i++){
            for(int j=1;j<=x[i]/2;j++){
                for(int k=j;k<=x[i]/2;k++){
                    for(int f=k;f<=x[i]/2;f++){
                        if((j*(j+1)/2 + k*(k+1)/2 + f*(f+1)/2) == x[i]){
                            System.out.println("1");
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 1){
                        break;
                    }
                }
                if(flag == 1){
                    break;
                }
            }
            if(flag == 0){
                System.out.println("0");
            }
            flag = 0;
        }

    }
}