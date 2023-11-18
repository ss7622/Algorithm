import java.util.Scanner;
import java.util.Arrays;


public class Main {

    public static int devide(char[] x, int left, int right){

        int mid = (left+right) / 2 ;

        if(right - left > 3) {
            int check = devide(x, left, mid-1);
            if (check == 0) {
                return 0;
            }
            check = devide(x, mid + 1, right);
            if (check == 0) {
                return 0;
            }
        }

        for(int i=left, k=right;i<mid;i++,k--){
            if(x[i] == x[k]){
                return 0;
            }
        }

        return 1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        String x;

        for(int i = 0;i<T;i++){
            x = sc.nextLine();

            int len = x.length();
            char[] split = new char[len];

            split = x.toCharArray();
            int check = devide(split,0,len-1);

            if(check == 1){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }


        }
    }
}
