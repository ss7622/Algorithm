class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] count = new int[n+1][m+1];
        count[1][1] = 1;
        
        for(int[] pu : puddles){
            count[pu[1]][pu[0]] = -1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1; j<=m;j++){
                if(count[i][j] == 0){
                    if(count[i-1][j] == -1){
                        count[i][j] = count[i][j-1];
                    }
                    else if(count[i][j-1] == -1){
                        count[i][j] = count[i-1][j];
                    }
                    else{
                        count[i][j] = (count[i-1][j] + count[i][j-1]) % 1000000007;
                    }
                }
            }
        }
        
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         System.out.print(count[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return count[n][m];
    }

}