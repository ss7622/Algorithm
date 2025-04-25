import java.util.*;
import java.lang.*;

class Solution {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(!stack.isEmpty()){
                char c = stack.pop();
                if(!valid(c,arr[i])){
                    stack.push(c);
                    stack.push(arr[i]);
                }
            }
            else{
                stack.push(arr[i]);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    public boolean valid(char a, char b) {
        if(a == '('){
            if(b != ')') {
                return false;
            }
            return true;
        }
        if(a == '['){
            if(b != ']') {
                return false;
            }
            return true;
        }
        if(a == '{'){
            if(b != '}') {
                return false;
            }
            return true;
        }
        return false;
    }
}