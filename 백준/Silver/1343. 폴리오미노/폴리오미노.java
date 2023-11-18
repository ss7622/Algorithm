import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();

        char s[] = x.toCharArray();

        int len = s.length;

        int cnt = 0;

        for(int i = 0;i<len;i++){
            if(s[i] == 'X'){
                cnt++;
            }
            if(i == len-1 || s[i+1] == '.') {
                if ((cnt % 4) % 2 != 0) {
                    System.out.print("-1");
                    return;
                }
            }
        }

        cnt = 0;

        for(int i = 0;i<len;i++){
            if(s[i] == '.'){
                System.out.print(".");
                continue;
            }
            if(s[i] == 'X'){
                cnt++;
            }
            if(i == len-1 || s[i+1] == '.'){
                if(cnt % 4 == 0){
                    for(int j = 0 ;j<cnt;j++){
                        System.out.print("A");
                    }
                }
                else if(cnt % 4 % 2 == 0){
                    for(int j = 0;j<cnt-2;j++){
                        System.out.print("A");
                    }
                    System.out.print("BB");
                }
                else{
                    System.out.println("BB");
                }
                cnt = 0;
            }
        }

    }
}
