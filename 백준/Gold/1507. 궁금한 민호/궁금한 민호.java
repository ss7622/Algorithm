import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int dp[][] = new int[n][n];

		for(int i=0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] check = new boolean[n][n];

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				for(int k=0;k<n;k++){
					if (k == i || k == j) continue;
					if(dp[i][k] + dp[k][j] == dp[i][j]){
						check[i][j] = true;
						check[j][i] = true;
					}
					if(dp[i][k] + dp[k][j] < dp[i][j]){
						System.out.println("-1");
						System.exit(0);
					}
				}
			}
		}
		int sum = 0;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(!check[i][j]) sum += dp[i][j];
			}
		}
		System.out.println(sum);
	}
}
