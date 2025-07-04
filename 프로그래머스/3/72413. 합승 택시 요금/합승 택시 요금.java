import java.util.*;
class Solution {
    class node{
        int nextIdx;
        int pay;
        
        public node(int a, int b){
            this.nextIdx = a;
            this.pay = b;
        }
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        Map<Integer, List<node>> map = new HashMap<>();
        
        for(int i=1;i<=n;i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int i=0;i<fares.length;i++){
            map.get(fares[i][0]).add(new node(fares[i][1], fares[i][2]));
            map.get(fares[i][1]).add(new node(fares[i][0], fares[i][2]));
        }
        
        int[] sdi = dijkstra(s, map, n);
        int[] adi = dijkstra(a, map, n);
        int[] bdi = dijkstra(b, map, n);
        
        int min = Integer.MAX_VALUE;

        for(int i=1;i<=n;i++){
            min = Math.min(sdi[i] + adi[i] + bdi[i], min);
        }
        
        return min;
        
    }
    
    public int[] dijkstra(int start, Map<Integer, List<node>> map, int n){
        Queue<node> que = new LinkedList<>();
        
        que.add(new node(start, 0));
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        
        while(!que.isEmpty()){
            
            node now = que.poll();
            
            int nowIdx = now.nextIdx;
            int cost = now.pay;
            
            if(dp[nowIdx] < cost) continue;
            
            List<node> toNodes = map.get(nowIdx);
            
            for(node toNode : toNodes){
                if(toNode.pay + cost < dp[toNode.nextIdx]){
                    dp[toNode.nextIdx] = toNode.pay + cost;
                    que.add(new node(toNode.nextIdx, toNode.pay + cost));
                }
            
            }
            
        }
        return dp;
    }
}