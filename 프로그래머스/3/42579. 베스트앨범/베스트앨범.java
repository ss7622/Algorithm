import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> one = new HashMap<>();
        Map<String, Integer> two = new HashMap<>();
        Map<String, Integer> oneIdx = new HashMap<>();
        Map<String, Integer> twoIdx = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();

        for(int i=0; i<genres.length; i++) {
            if(one.containsKey(genres[i])) {
                if(one.get(genres[i]) < plays[i]) {
                    Integer x = one.get(genres[i]);
                    one.put(genres[i], plays[i]);
                    Integer idxx = oneIdx.get(genres[i]);
                    oneIdx.put(genres[i], i);
                    if(two.containsKey(genres[i])) {
                        if(two.get(genres[i]) < x) {
                            two.put(genres[i], x);
                            twoIdx.put(genres[i], idxx);
                        }
                    }
                    else{
                        two.put(genres[i], x);
                        twoIdx.put(genres[i], idxx);
                    }
                }
                else if(two.containsKey(genres[i])) {
                    if(two.get(genres[i]) < plays[i]) {
                        two.put(genres[i], plays[i]);
                        twoIdx.put(genres[i], i);
                    }
                }
                else {
                    two.put(genres[i], plays[i]);
                    twoIdx.put(genres[i], i);
                }
            }
            else {
                one.put(genres[i], plays[i]);
                oneIdx.put(genres[i], i);
            }
            sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> sortedKeys = sum.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()); // Collectors.toList()로 변경


        List<Integer> res = new ArrayList<>();
        int reFlag = 0;
        for(int i=0; i<sortedKeys.size(); i++) {
            res.add(oneIdx.get(sortedKeys.get(i)));
            if(twoIdx.containsKey(sortedKeys.get(i))) {
                res.add(twoIdx.get(sortedKeys.get(i)));
            }
        }
        
        int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}