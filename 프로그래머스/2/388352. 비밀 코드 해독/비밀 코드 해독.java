import java.util.*;
import java.io.*;
import java.lang.*;
class Solution {
    static int n2;
    static int[][] q2;
    static int[] ans2;
    static int result = 0;
    public int solution(int n, int[][] q, int[] ans) {
        n2 = n;
        q2 = q;
        ans2 = ans;
        
        dfs(1, new ArrayList<Integer>());
        
        return result;
    }
    
    public static void dfs(int now, List<Integer> lis){
        if(lis.size() == 5){
            int cnt = 0;
            // for(Integer s : lis){
            //     System.out.print(" " + s);
            // }
            // System.out.println();
            for(int i=0;i<ans2.length;i++){
                cnt = 0;
                for(int j=0;j<5;j++){
                    for(Integer l : lis){
                        if(l == q2[i][j]){
                            cnt++;
                        }
                    }
                }
                // System.out.println(" i : " + i  + " 일치하는 갯수 : " + cnt);
                if(cnt != ans2[i]) return;
            }
            
            result++;
            return;
        }
        
        for(int i=now;i<=n2;i++){
            lis.add(i);
            dfs(i+1, lis);
            lis.remove(lis.size()-1);
        }
    }
}