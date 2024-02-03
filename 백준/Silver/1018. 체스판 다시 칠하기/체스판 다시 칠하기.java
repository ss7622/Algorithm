
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int min = 999;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char arr[][] = new char[N][M];

        for(int j=0;j<N;j++){
            arr[j] = br.readLine().toCharArray();
        }

        int yflag = 0;
        int xflag = 0;
        int mincheck = 0;
        int check = 0;

        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                xflag = j%2;
                yflag = i%2;
                for (int y = i; y < i + 8 && i+8 <= N; y++) {
                    for (int x = j;x<j+8 && j+8 <= M;x++){
                        if(x%2 == xflag && y%2 == yflag){
                            if(arr[i][j] != arr[y][x]){
                                mincheck++;
                            }
                        }
                        else if(x%2 != xflag && y%2 == yflag){
                            if(arr[i][j] == arr[y][x]){
                                mincheck++;
                            }
                        }
                        else if(y%2 != yflag && x%2 == xflag){
                            if(arr[i][j] == arr[y][x]){
                                mincheck++;
                            }
                        }
                        else if(y%2 != yflag && x%2 != xflag){
                            if(arr[i][j] != arr[y][x]){
                                mincheck++;
                            }
                        }
                        check = 1;
                    }
                }

                if(check == 1) {
                    check = 0;
                    mincheck = Math.min(mincheck,64 - mincheck);
                    min = Math.min(min,mincheck);
                }


                mincheck = 0;
            }
        }

        System.out.println(min);
    }
}