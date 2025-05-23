import java.util.*;
class Solution {
    static boolean[] visited;
    static int[] childNum;
    public int solution(int n, int[][] wires) {
        visited = new boolean[n+1];
        childNum = new int[n+1];
        visited[wires[0][0]] = true;
        dfs(wires,wires[0][0]);
        int min = Integer.MAX_VALUE;
        
        for(int i=1;i<childNum.length;i++){
            System.out.println(childNum[i]);
            min = Math.min(min,Math.abs((n - childNum[i]) - childNum[i]));
        }
        return min;
    }
    
    public int dfs(int[][] wires, int now){
        int sum = 0;
        for(int i=0; i<wires.length;i++){
            if(now == wires[i][0] && !visited[wires[i][1]]){
                visited[wires[i][1]] = true;
                sum += dfs(wires,wires[i][1]);
            }
            if(now == wires[i][1] && !visited[wires[i][0]]){
                visited[wires[i][0]] = true;
                sum += dfs(wires,wires[i][0]);
            }
        }
        return childNum[now] = sum + 1;
    }
}