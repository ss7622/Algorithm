import java.util.*;

class Solution {
    
    static boolean[] visited;
    static List<Integer> history;
    static int maxSheepCnt = 0;
    static int[] info2;
    static int[][] edge;
    
    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length];
        history = new ArrayList<>();
        info2 = info;
        edge = edges;
        
        visited[0] = true;
        history.add(0);
        dfs(0,1);
        
        return maxSheepCnt;
    }
    
    public void dfs(int wolfCnt, int sheepCnt){
        if(wolfCnt >= sheepCnt){
            return;
        }
        maxSheepCnt = Math.max(maxSheepCnt, sheepCnt);
        
        for(int i=0;i<edge.length;i++){
            for(int j=0;j<history.size(); j++){
                if(edge[i][0] == history.get(j) && !visited[edge[i][1]]){
                    visited[edge[i][1]] = true;
                    history.add(edge[i][1]);
                    if(info2[edge[i][1]] == 0){
                        dfs(wolfCnt, (sheepCnt+1));
                    }
                    if(info2[edge[i][1]] == 1){
                        dfs(wolfCnt+1,sheepCnt);
                    }
                    visited[edge[i][1]] = false;
                    history.remove(history.size()-1);
                }
                
                if(edge[i][1] == history.get(j) && !visited[edge[i][0]]){
                    visited[edge[i][0]] = true;
                    history.add(edge[i][0]);
                    if(info2[edge[i][0]] == 0){
                        dfs(wolfCnt,sheepCnt+1);
                    }
                    if(info2[edge[i][0]] == 1){
                        dfs(wolfCnt+1,sheepCnt);
                    }
                    visited[edge[i][0]] = false;
                    history.remove(history.size()-1);
                }
            }
        }
        
    }
}