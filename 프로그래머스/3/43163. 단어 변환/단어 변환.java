import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] wordss) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> que = new LinkedList<>();
        String[] words = new String[wordss.length+1];
        words[0] = begin;
        int flag = 1;
        for(String word : wordss){
            words[flag++] = word;
        }
        que.add(new int[] {0,0});
        visited.add(begin);
        
        while(!que.isEmpty()){
            int[] now = que.poll();
            
            if(words[now[0]].equals(target)){
                return now[1];
            }
            
            for(int i=0;i<words.length;i++){
                if(!visited.contains(words[i]) && getChai(words[now[0]], words[i])){
                    visited.add(words[i]);
                    que.add(new int[] {i,now[1]+1});
                }
            }
        }
        return 0;
        
    }
    
    public boolean getChai(String a, String b){
        char[] a2 = a.toCharArray();
        char[] b2 = b.toCharArray();
        int sum = 0;
        
        for(int i=0;i<a2.length;i++){
            if(a2[i] != b2[i]){
                sum++;
            }
        }
        
        if(sum == 1){
            return true;
        }
        return false;
    }
}