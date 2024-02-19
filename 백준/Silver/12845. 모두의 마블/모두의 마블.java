
import java.util.Scanner;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		int N = sc.nextInt();
		int x[] = new int[N];
		int max=0,sum = 0;
		
		for(int i=0; i<N;i++) {
			x[i] = sc.nextInt();
			max = Math.max(max, x[i]);
			sum += x[i];
		}
		
		sum = sum - max;
		
		System.out.println(max * (N-1) + sum);
		
		
		
		
	}

}
