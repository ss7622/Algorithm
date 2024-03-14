
import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String grade[] = new String[N];
        int x[] = new int[N];
        int xflag = 0;

        for(int  i = 0 ;i<N;i++){
            st = new StringTokenizer(br.readLine());
            grade[i] = st.nextToken();
            x[i] = Integer.parseInt(st.nextToken());
        }
        int jun[] = new int[M];
        for(int i =  0 ;i<M;i++) {
            jun[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0 ;i<M;i++){
            int flag = binarySearch(x, 0, N / 2, N, jun[i]);
            bw.write(grade[flag]);
            bw.write("\n");
        }

        bw.flush();



    }
    public static int binarySearch(int x[], int left, int mid, int right,int target){
        if(left >= right){
            return left;
        }
        if(target <= x[mid]){
            right = mid;
            mid = (left + right)/2;
            return binarySearch(x,left,mid,right,target);

        }
        else{
            left = mid + 1;
            mid = (left + right)/2;
            return binarySearch(x,left,mid,right,target);

        }
    }
}
