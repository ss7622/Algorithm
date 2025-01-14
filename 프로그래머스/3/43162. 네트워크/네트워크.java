class Solution {
    static int count = 0;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, n, computers);
                count++;
            }
        }
        return count;
    }
    
    public static void dfs(int start, int n, int[][] computers){
        for(int i=0;i<n;i++){
            if(computers[start][i] == 1){
                if(!visited[i]){
                    visited[i] = true;
                    dfs(i, n, computers);
                }
            }
        }
    }
}