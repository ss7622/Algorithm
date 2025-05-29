class Solution {
    static int[] child;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        visited = new boolean[n+1];
        child = new int[n+1];
        
        visited[wires[0][0]] = true;
        dfs(wires[0][0], wires);
        
        int min = Integer.MAX_VALUE;
        
        for(int i=1;i<n+1;i++){
            min = Math.min( Math.abs((n - child[i]) - child[i]), min);
        }
        
        return min;
    }
    
    public int dfs(int now, int[][] wires){
        int cnt = 0;
        for(int i=0;i<wires.length;i++){
            if(wires[i][0] == now && !visited[wires[i][1]]){
                visited[wires[i][1]] = true;
                cnt += dfs(wires[i][1], wires);
            }
            
            if(wires[i][1] == now && !visited[wires[i][0]]){
                visited[wires[i][0]] = true;
                cnt += dfs(wires[i][0], wires);
            }
        }
        return child[now] = cnt+1;
    }
}