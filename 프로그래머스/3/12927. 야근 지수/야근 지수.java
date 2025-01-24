import java.util.*;

class Solution {
    public  long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.add(work);
        }

        for(int i=0;i<n;i++){
            Integer poll = pq.poll();
            if(poll>0){
                pq.add(poll-1);
            }
            else{
                pq.add(0);
            }
        }

        long result = 0;
        for (Integer i : pq) {
            result += Math.pow(i,2);
        }
        return result;
    }
}