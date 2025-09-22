import java.util.*;
	 class Solution {
		public int solution(int[][] routes) {
			Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);
			int cnt = 0;
			int min = Integer.MAX_VALUE;
			for (int[] route : routes) {
				if(min < route[0]){
					cnt++;
					min = route[1];
					continue;
				}
				min = Math.min(min, route[1]);
			}
			cnt++;
			return cnt;
		}
	}