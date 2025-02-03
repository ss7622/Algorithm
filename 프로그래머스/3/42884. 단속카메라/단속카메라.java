import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

class Solution {
    public static int solution(int[][] routes) {
        // 첫 번째 원소 기준으로 오름차순 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[0], b[0]));

        int max = routes[0][1];
        int cnt = 1;

        for (int[] route : routes) {
            if(max > route[1]){
                max = route[1];
            }
            if (max < route[0]) {
                cnt++;
                max = route[1];
            }
        }

        return cnt; // 예제에서는 반환값이 필요해서 임시로 0을 반환
    }
}