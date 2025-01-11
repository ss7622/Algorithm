import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;


class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 1) + 1);
        }
        int sum = 1;
        for (Integer value : map.values()) {
            sum *= value;
        }
        return sum-1;
    }
}