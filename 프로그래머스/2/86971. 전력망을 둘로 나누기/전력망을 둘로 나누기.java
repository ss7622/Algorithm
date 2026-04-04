import java.util.*;
class Solution {
    static int[] childCnt;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        childCnt = new int[n+1];
        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1, wires);
        
        int min = Integer.MAX_VALUE;
        
        for(int i : childCnt){
            min = Math.min(min, Math.abs((n - i) - i));
        }
        return min;
        
    }
    public int dfs(int now, int[][] wires){
        int sum = 0;
        for(int i=0;i<wires.length;i++){
            if(now == wires[i][0] && !visited[wires[i][1]]){
                visited[wires[i][1]] = true;
                sum += dfs(wires[i][1], wires);
            }
            if(now == wires[i][1] && !visited[wires[i][0]]){
                visited[wires[i][0]] = true;
                sum += dfs(wires[i][0], wires);
            }
        }
        return childCnt[now] = sum + 1;
    }
}