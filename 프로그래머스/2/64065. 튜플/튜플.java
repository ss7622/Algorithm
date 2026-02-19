import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        String[] x = s.split("},");
        
        for(int i=0;i<x.length;i++){
            x[i] = x[i].replace("}","");
            x[i] = x[i].replace("{","");
        }
        
        Arrays.sort(x, (a1, a2) -> {
            return a1.length() - a2.length();
        });
        
        int[] answer = new int[x.length];
        int idx = 0;
        
        Set<Integer> set = new LinkedHashSet<>();
        
        for(String a : x){
            StringTokenizer st = new StringTokenizer(a, ",");
            
            while(st.hasMoreTokens()){
                set.add(Integer.parseInt(st.nextToken()));
            }
        }
        
        for(Integer a : set){
            answer[idx++] = a;
        }
        
        return answer;
    }
}