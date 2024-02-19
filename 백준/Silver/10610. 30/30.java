
import java.util.Scanner;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String flag= null;
		int yy = 0;
		String x;
		x = sc.nextLine();
		String N[] = x.split("");
		
		int num = x.length();
		int sum=0;
		
		for(int i=0;i<num;i++) {
			sum += Integer.parseInt(N[i]);
			if(Integer.parseInt(N[i]) == 0) {
				yy = 1;
			}
		}
		
		if(sum % 3 == 0 && yy == 1) {
			Arrays.sort(N);
			
			for(int i=num-1;i>=0;i--) {
				System.out.print(N[i]);
			}
			                       
		}
		
		else {
			System.out.println(-1);
		}
		
		
		
		
		
		
				
		
		
	}

}
