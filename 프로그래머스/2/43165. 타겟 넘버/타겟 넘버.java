class Solution {
    static int cnt = 0;
    static int tar = 0;
    public int solution(int[] numbers, int target) {
        tar = target;
        
        dfs(numbers, 0, 0, 0);
        return cnt;
    }
    
    public void dfs(int[] numbers, int depth, int num, int st){
        
        if(depth == numbers.length){
            if(num == tar){
                cnt++;
            }
        }
        
        for(int i=st;i<numbers.length;i++){
            dfs(numbers, depth+1, num + numbers[i], i+1);
        }
        
        for(int i=st;i<numbers.length;i++){
            dfs(numbers, depth+1, num - numbers[i], i+1);
        }
    }
}