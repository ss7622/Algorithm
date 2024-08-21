import java.io.*;


public class Main {

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        bw.write((a+b-c) + "\n");
        String s = String.valueOf(a) + String.valueOf(b);

        bw.write(String.valueOf(Integer.parseInt(s) - c));
        bw.flush();


    }

}