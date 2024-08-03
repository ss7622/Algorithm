
import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> a = new ArrayList<Integer>();
        a.add(A);
        int index = 0 ;
        int  i = 0;
        while(true){
            int s = cal(a.get(i),P);
            if(a.contains(s)){
                index = a.indexOf(s);
                break;
            }

            a.add(s);
            i++;
        }

        bw.write(String.valueOf(index));
        bw.flush();

    }

    public static int cal(int x, int p){
        String s = String.valueOf(x);

        char n[] = s.toCharArray();

        int sum =0;

        for(int i= 0 ;i<n.length;i++){
            sum += (int) Math.pow(Integer.parseInt(String.valueOf(n[i])),p);
        }

        return sum;
    }
}