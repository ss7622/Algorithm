import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.StringTokenizer;
import javax.lang.model.SourceVersion;

public class Main {
    static int min = 500000, x;
    static int[] forbidden;
    static int digit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        x = Integer.parseInt(br.readLine());

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        forbidden = new int[t];
        if(t != 0) {
            st = new StringTokenizer(br.readLine());
        }

        for(int i =0;i<t;i++){
            forbidden[i] = Integer.parseInt(st.nextToken());
        }
        digit = getDigit(x);
        min = Math.abs(x - 100);
        dfs(0,0);
        System.out.println(min);
    }

    public static void dfs(int depth, int result){
        if(depth != 0){
            min = Math.min(Math.abs(result-x) + getDigit(result), min);
        }
        if(depth == digit+1){
            return;
        }

        for(int  j=0;j<10;j++){
            if(can(j)){
                dfs(depth+1,result * 10 + j);
            }
        }

    }

    public static boolean can(int num){
        for (int i : forbidden) {
            if(num == i){
                return false;
            }
        }
        return true;
    }

    public static int getDigit(int num){
        int digit = 1;
        while(num >= 10){
            num /= 10;
            digit++;
        }
        return digit;
    }
}