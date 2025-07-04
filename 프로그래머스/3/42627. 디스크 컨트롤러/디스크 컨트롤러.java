import java.util.*;
class Solution {
    class disk{
        int num;
        int start;
        int time;
        
        public disk(int n, int s, int t){
            this.num = n;
            this.start = s;
            this. time = t;
        }
    }
    public int solution(int[][] jobs) {
        Queue<disk> que = new PriorityQueue<>((a, b) -> a.time - b.time);
        Arrays.sort(jobs, (int[] a, int[] b) -> a[0] - b[0]);
        
        Set<Integer> visited = new HashSet<>();
        
        int cnt = 0;
        int nowTime = jobs[0][0];
        
        int sum = 0;
        
        while(cnt != jobs.length){
            for(int i=0;i<jobs.length;i++){
                if(jobs[i][0] <= nowTime && !visited.contains(i)){
                    que.add(new disk(i, jobs[i][0], jobs[i][1]));
                    visited.add(i);
                }
            }
            
            if(que.isEmpty()){
                nowTime++;
            }
            
            if(!que.isEmpty()){
                disk now = que.poll();
                
                nowTime += now.time;
                
                sum += nowTime - now.start;
                cnt++;
            }
            
        }
        
        return sum / jobs.length;
    }
}