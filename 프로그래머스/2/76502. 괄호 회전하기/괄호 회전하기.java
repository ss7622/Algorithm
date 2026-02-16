import java.util.*;
import java.lang.*;
class Solution {
    static int c = 0;
    public int solution(String s) {
        
        for(int i=0;i<s.length();i++){
            int cnt = 0;
            int j = i;
            char[] x = new char[s.length()];
            int xflag= 0 ;
            while(cnt < s.length()){
                x[xflag++] = s.charAt(j);
                j++;
                if(j >= s.length()){
                    j = 0;
                }
                cnt++;
            }
            
            check(x);
        }
        
        System.out.println(c);
        return c;
    }
    
    public static void check(char[] x){
        Stack<String> stack = new Stack<>();

        for(int i=0;i<x.length;i++){
            if(!stack.isEmpty()){
                String now = stack.pop();

                if(!sex(now, String.valueOf((x[i])))){
                    stack.add(now);
                    stack.add(String.valueOf(x[i]));
                }
            }else{
                stack.add(String.valueOf(x[i]));
            }
        }
        
        
        if(stack.isEmpty()){
            c++;
        }

    }
    
    public static boolean sex(String a, String b){

        if(a.equals("[") && b.equals("]")) return true;
        if(a.equals("{") && b.equals("}")) return true;
        if(a.equals("(") && b.equals(")")) return true;
        
        return false;

    }
}