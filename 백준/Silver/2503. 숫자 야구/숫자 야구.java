
import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> x = new ArrayList<>();

        for(int i = 100;i<999;i++){
            if(i%10 != i/10%10 && i%10 != i/100 && i/100 != i/10%10){
                if(i%10 != 0 && i/10%10 != 0) {
                    x.add(i);
                }
            }
        }

        int N = Integer.parseInt(bf.readLine());
        
        for(int i = 0 ;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            
            int k = Integer.parseInt(st.nextToken());
            int sk = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            List<Integer> toRemove = new ArrayList<>();
            int a = k / 100, b = k/10%10,c = k%10;
            

            for (Integer hu : x) {
                int ah = hu / 100, bh = hu/10%10,ch = hu%10;
                int scount = 0;
                int bcount=0;
                if(ah == a){
                    scount++;
                }
                else if(ah == b){
                    bcount++;
                }
                else if(ah == c){
                    bcount++;
                }
                if(bh == a){
                    bcount++;
                }
                else if(bh == b){
                    scount++;
                }
                else if(bh == c){
                    bcount++;
                }
                if(ch == a){
                    bcount++;
                }
                else if(ch == b){
                    bcount++;
                }
                else if(ch == c){
                    scount++;
                }

                
                if(scount != sk || bcount != ball){
                    toRemove.add(hu);
                }
            }

            for (Integer r : toRemove) {
                x.remove(r);
            }
            
            
        }

        System.out.println(x.size());

    }
}
