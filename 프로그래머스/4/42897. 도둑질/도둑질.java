import java.util.*;
class Solution {
    public int solution(int[] money) {
        int[] dp1 = new int[money.length+1];
        int[] dp2 = new int[money.length+1];
        //1은 포함 됐을 때
        //2는 안됐을 때
        dp1[0] = money[money.length-1];
        dp2[0] = money[0];

        
        if(money.length > 2){
            dp1[1] = money[money.length-1]+ money[1];
            dp2[1] = Math.max(money[0], money[1]);
        }
        if(money.length == 3){
            return Math.max(Math.max(money[0], money[1]), money[2]);
        }
        
        if(money.length > 3){
            dp1[2] = Math.max(money[money.length-1] + money[1], money[money.length-1] + money[2]);
            dp2[2] = Math.max(money[1], money[0] + money[2]);
        }
        if(money.length == 4){
            return Math.max(money[0] + money[2], money[1]+ money[3]);
        }
        
        if(money.length > 4){
            dp1[3] = Math.max(money[money.length-1] + money[1] + money[3], money[money.length-1] + money[2]);

            dp2[3] = Math.max(Math.max(money[0] + money[2], money[1] + money[3]), money[0] + money[3]);
        }
        
        if(money.length == 5){
            return Math.max(Math.max(Math.max(Math.max(money[0] + money[2], money[0] + money[3]),money[1]+money[3] ), money[1]+money[4]),money[2] + money[4] );
        }
        
        
        
        for(int i=4;i<money.length-1;i++){
            dp1[i] = Math.max(Math.max(dp1[i-1], dp1[i-2] + money[i]), dp1[i-3] + money[i]);
            dp2[i] = Math.max(Math.max(dp2[i-1], dp2[i-2] + money[i]), dp2[i-3] + money[i]);

        }
        
        
        return Math.max(dp1[money.length-3], dp2[money.length-2]);
    }
}


// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    
// 1, 3, 5
// 1, 4
// 2, 4

