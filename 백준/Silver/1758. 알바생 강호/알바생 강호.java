import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String input;

        Long x[] = new Long[T];

        for(int i = 0;i<T;i++){
            input = br.readLine();
            x[i] = Long.parseLong(input);
        }

        Arrays.sort(x,Collections.reverseOrder());

        Long sum = 0L;
        int cnt = 0;

        for (Long i : x) {
            if(i-cnt > 0) {
                sum += i - cnt;
            }
            cnt++;
        }

        System.out.println(sum);


    }
}
