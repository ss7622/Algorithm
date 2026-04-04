import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int left = 0;
        int right = distance;
        Arrays.sort(rocks);
        while(left <= right){
            int mid = (left + right) / 2;
            int deleteCnt = 0;

            int[] cpRocks = new int[rocks.length + 2];
            cpRocks[0] = 0;
            cpRocks[cpRocks.length-1] = distance;

            for(int i=0;i<rocks.length;i++){
                cpRocks[i+1] = rocks[i];
            }
            
            for(int i=1;i<cpRocks.length;i++){
                if(cpRocks[i] - cpRocks[i-1] < mid && i != cpRocks.length-1){
                    deleteCnt++;
                    cpRocks[i] = cpRocks[i-1];
                }
            }
            
            if(cpRocks[cpRocks.length-1] - cpRocks[cpRocks.length-2] < mid){
                deleteCnt++;
            }
            
            if(deleteCnt > n){
                right = mid - 1 ;
            }
            else{
                left = mid + 1;
            }


        }
        return right;
    }
}
