
import java.util.Scanner;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N,x,mok;
		
		N = sc.nextInt();
		
		x = N  % 5;
		mok = N / 5;
		
		if(x % 3 == 0) {
			mok += (x / 3);
			System.out.println(mok);
		}
		else if(N>12 && (N-12)%5 == 0) {
			System.out.println((N-12)/5 + 4);
		}
		else if(N>9 && (N-9)%5 == 0) {
			System.out.println((N-9)/5 + 3);
		}
		else if(x == 1) {
			System.out.println(mok+1);
		}
		else if(N % 3 == 0){
			mok = N / 3;
			System.out.println(mok);
		}
		else {
			System.out.println(-1);
		}
				
		
		
	}

}
