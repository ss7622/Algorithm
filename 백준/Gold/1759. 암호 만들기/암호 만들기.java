import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int C;
    static boolean[] visited;
    static char[] en;
    static List<String> last = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[C];
        en = new char[C];
        char[] nchar = new char[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            en[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(en);
        dfs(0,0,nchar);
    }

    public static void dfs(int st, int depth, char[] re){
        if(depth == N){
            if(check(re)){
                System.out.println(String.valueOf(re));
            }
            return;
        }

        for(int  i = st;i<C;i++){
            re[depth] = en[i];
            dfs(i+1, depth+1, re);
        }

    }

    public static boolean check(char[] res){
        int mou = 0;
        int ja = 0;
        for (char re : res) {
            if(re == 'a' || re == 'e' || re == 'i' || re == 'o' || re == 'u'){
                mou++;
            }
            else{
                ja++;
            }
        }
        if(mou >= 1 && ja >= 2){
            return true;
        }
        return false;
    }
}