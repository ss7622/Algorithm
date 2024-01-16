
import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String l = bf.readLine();
        String x[] = l.split(" ");

        HashMap<String, String> map = new HashMap<String, String>();
        for (String s : x) {
            map.put(s,s);
        }
        int M = Integer.parseInt(bf.readLine());
        l = bf.readLine();
        String c[] = l.split(" ");

        for (String s : c) {
            try {
                if (map.get(s).equals(s)) {
                    System.out.print("1 ");
                }
            }
            catch(NullPointerException e) {

                System.out.print("0 ");

            }
        }


    }
}