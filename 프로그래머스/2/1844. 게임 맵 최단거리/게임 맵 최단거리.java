import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[][] maps) {
        int[] toY = {0,0,1,-1};
        int[] toX = {1,-1,0,0};
        
        boolean visited[][] = new boolean[maps.length][maps[0].length];
        Queue<int[]> que = new LinkedList<>();
        
        que.add(new int[] {0,0,1});
        visited[0][0] = true;
        
        while(!que.isEmpty()){
            int[] now = que.poll();
            
            if(now[0] == maps.length-1 && now[1] == maps[0].length-1){
                return now[2];
            }
            
            for(int i=0;i<4;i++){
                int nextY = now[0] + toY[i];
                int nextX = now[1] + toX[i];
                
                if(nextY >= 0 && nextY < maps.length && nextX >= 0 && nextX < maps[0].length
                  && !visited[nextY][nextX] && maps[nextY][nextX] == 1){
                    visited[nextY][nextX] = true;
                    que.add(new int[] {nextY, nextX, now[2] + 1});
                }
            }
        }
        return -1;
        
    }
}