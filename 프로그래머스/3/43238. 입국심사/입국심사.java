class Solution {

    public long solution(int n, int[] times) {
        long result = bSearch(1L, 1000000000000000000L, times, n);
        return result+1;
    }
    public long bSearch(long left, long right, int[] times, int n){
        long mid = 0L;
        while(left <= right){
            mid = (left + right) / 2;
            
            long sum = 0;
            
            for(int time : times){
                sum += mid / time;
            }
            
            if(sum >= n){
                right = mid -1;
            }
            
            else{
                left = mid+1;
            }
            mid = (left + right) / 2;

            
        }
        return mid;
    }
}