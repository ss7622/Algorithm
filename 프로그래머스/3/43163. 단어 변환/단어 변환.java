import java.util.*;
import java.lang.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> visited = new HashSet<>();
        Queue<String[]> que = new LinkedList<>();
        
        que.add(new String[] {begin, "0"});
        
        while(!que.isEmpty()){
            String[] now = que.poll();
            if(now[0].equals(target)){
                return Integer.parseInt(now[1]);
            }
            
            for(int i=0;i<words.length;i++){
                if(!visited.contains(words[i]) && check(words[i], now[0])){
                    visited.add(words[i]);
                    que.add(new String[] {words[i],String.valueOf( Integer.parseInt(now[1]) + 1)});
                }
            }
        }
        
        return 0;
    }
    
    public boolean check(String a, String b){
        char[] a2 = a.toCharArray();
        char[] b2 = b.toCharArray();
        int cnt = 0;
        for(int i=0;i<a2.length;i++){
            if(a2[i] == b2[i]){
                cnt++;
            }
        }
        
        if(cnt == a2.length-1){
            return true;
        }
        return false;
    }
}