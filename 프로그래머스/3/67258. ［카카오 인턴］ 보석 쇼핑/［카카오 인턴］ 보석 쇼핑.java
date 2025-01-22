import java.util.*;

class Solution {

    static int totalCnt = 0;
    static int min = 100001;
    static int st = 0;
    static int en = 0;

    public static int[] solution(String[] gems) {
        Set<String> initial = new HashSet<>(Arrays.asList(gems));
        totalCnt = initial.size();

        HashMap<String, Integer> map = new HashMap<>();
        int flag = 0;
        int start = 0;

        for(int i=0;i<gems.length;i++) {
            if(map.containsKey(gems[i])) {
                if(map.get(gems[i]) == start) {
                    flag = 0;
                }
            }
            map.put(gems[i], i);
            if(map.size() == totalCnt && flag == 0) {
                flag = 1;
                start = 10000000;
                int end = 0;
                for (Integer value : map.values()) {
                    start = Math.min(value, start);
                    end = Math.max(value, end);
                }
                if(min > end - start){
                    min = end - start;
                    st = start;
                    en = end;
                }
            }
        }

        int[] k = {st+1, en+1};
        return k;
    }
}