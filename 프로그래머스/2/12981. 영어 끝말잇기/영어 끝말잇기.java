import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int humanNumber = 0;
        int turn = 0;

        set.add(words[0]);

        for(int i = 1; i < words.length; i++){
            if(set.contains(words[i]) || check(words[i-1], words[i]) || words[i].length() == 1){
                humanNumber = (i+1) % n == 0 ? n : (i+1) % n;
                turn = (i+1) % n == 0 ? (i+1) / n : (i+1) / n + 1;
                break;
            }
            else{
                set.add(words[i]);
            }
        }

        return new int[]{humanNumber, turn};
    }

    public boolean check(String a, String b){
        char[] a2 = a.toCharArray();
        char[] b2 = b.toCharArray();

        return a2[a2.length - 1] != b2[0];
    }
}