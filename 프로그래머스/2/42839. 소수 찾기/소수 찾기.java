import java.util.*;
class Solution {
    public static boolean[] visited;
    static int max = 0;
    public int cnt = 0;
    public static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        dfs("", numbers);
        return max;
    }
    
    public void dfs(String x, String numbers){
                
        if(x.length() != 0 && sosu(Integer.parseInt(x))
          && !set.contains(Integer.parseInt(x))){
            set.add(Integer.parseInt(x));
            cnt++;
        }
        
         max = Math.max(max, cnt);

        
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(x + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
    
    public boolean sosu(int a){
        
        if(a == 1 || a == 0){
            return false;
        }
        
        for(int i=2;i<=Math.sqrt(a);i++){
            if(a % i == 0){
                return false;
            }
        }
        return true;
    }
}