import java.util.*;

class Solution {
    static boolean visited[][];
    static int[] toY = {0,0,1,-1};
    static int[] toX = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        int yLength = maps.length;
        int xLength = maps[0].length;
        visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {0,0,1});
        
        while(!que.isEmpty()){
            int[] now = que.poll();
            
            if(now[0] == yLength-1 && now[1] == xLength-1){
                return now[2];
            }
            
            for(int i=0;i<4;i++){
                int nextY = now[0] + toY[i];
                int nextX = now[1] + toX[i];
                
                if(nextY >= 0 && nextY < yLength && nextX >= 0 && nextX < xLength
                  && !visited[nextY][nextX] && maps[nextY][nextX] == 1){
                    visited[nextY][nextX] = true;
                    que.add(new int[] {nextY, nextX, now[2]+1});
                }
            }
        }
        
        
        return -1;
    }
}