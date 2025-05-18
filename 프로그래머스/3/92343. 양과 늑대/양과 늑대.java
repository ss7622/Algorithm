import java.util.*;
class Solution {
    static int[] info2;
    static int[][] edges2;
    static boolean[] visited;
    static List<Integer> history = new ArrayList<>();
    static int max = 0;
    public int solution(int[] info, int[][] edges) {
        info2 = info;
        edges2 = edges;
        visited = new boolean[info.length];
        visited[0] = true;
        history.add(0);
        dfs(0,1,0);
        return max;
    }
    
    public void dfs(int now, int sheepCnt, int wolfCnt){
        // System.out.println(now);
        if(sheepCnt <= wolfCnt){
            return;
        }
        
        max = Math.max(sheepCnt, max);

        
        for(int i=0;i<edges2.length;i++){
            for(int j=0;j<history.size();j++){
                // System.out.println("탐색 : " + edges2[i][0]);
                // System.out.println("방문했던 곳 : " + history.get(j));

                if(edges2[i][0] == history.get(j) && !visited[edges2[i][1]]){
                    if(info2[edges2[i][1]] == 0){
                        visited[edges2[i][1]] = true;
                        history.add(edges2[i][1]);
                        dfs(edges2[i][1],sheepCnt+1,wolfCnt);
                        history.remove(history.size()-1);
                        visited[edges2[i][1]] = false;
                    }
                    else{
                        visited[edges2[i][1]] = true;
                        history.add(edges2[i][1]);
                        dfs(edges2[i][1],sheepCnt,wolfCnt+1);
                        history.remove(history.size()-1);
                        visited[edges2[i][1]] = false;
                    }
                }
            }
        }
    }
}