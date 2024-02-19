
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String x = sc.nextLine();
        char y[] = new char[50];
        String y1 = null;
        int yflag = 0;
        char x1[] = x.toCharArray();
        int sum[] = new int[51];
        int sumflag = 0;
        int flag = 0;
        int k = 0;
        int l=0;

        int len = x.length();


        for(int i=0;i<len;i++){
            if(i == len-1){
                y[yflag++] = x1[i];
                for(int j=yflag-1;j>=0;j--){
                    int n = (int)y[j] - '0';
                    k += (n*Math.pow(10,l++));
                }

                if(flag == 1) {
                    sum[sumflag++] = k * -1;
                }
                else{
                    sum[sumflag++] = k;
                }
                k=0;
                yflag=0;
                break;
            }
            if(x1[i] != '-' && x1[i] != '+'){
                y[yflag++] = x1[i];
            }
            else if(flag == 1){
                for(int j=yflag-1;j>=0;j--){
                    int n = (int)y[j] - '0';
                    k += (n*Math.pow(10,l++));
                }
                sum[sumflag++] = k * -1;
                k=0;
                yflag=0;
                l=0;

            }
            else if(x1[i] == '-'){
                for(int j=yflag-1;j>=0;j--){
                    int n = (int)y[j] - '0';
                    k += (n*Math.pow(10,l++));
                }
                sum[sumflag++] = k;
                k=0;
                flag = 1;
                yflag =0;
                l=0;
            }
            else{
                for(int j=yflag-1;j>=0;j--){
                    int n = (int)y[j] - '0';
                    k += (n*Math.pow(10,l++));
                }
                sum[sumflag++] = k;
                k=0;
                yflag = 0;
                l=0;
            }

        }


        int s = 0;
        for(int i=0;i<sumflag;i++){
            s += sum[i];
        }

        System.out.println(s);




    }
}
