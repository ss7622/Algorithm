import java. util.*;

class Solution {
    public static int solution(int[] queue1, int[] queue2) {
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        
        long q1sum = 0;
        long q2sum = 0;

        for (int i : queue1) {
            q1.add(i);
            q1sum += i;
        }
        for (Integer i : queue2) {
            q2.add(i);
            q2sum += i;
        }

        int flag = 0;
        int re = 0;
        int maxlen = Math.max(queue1.length, queue2.length);

        while(flag < maxlen*2.5) {

//             for (Integer i : q1) {
//                 System.out.print(" "+ i);
//             }
//             System.out.println();

//             for (Integer i : q2) {
//                 System.out.print(" " + i);
//             }
//             System.out.println();
//             System.out.println("-------------------------------");

            if(q1sum == q2sum){
                re = 1;
                break;
            }

            if(q1sum > q2sum) {
                int pop = q1.pop();
                q2.addLast(pop);
                
                q1sum -= pop;
                q2sum += pop;
                flag++;
            }
            else {
                int pop = q2.pop();
                q1.addLast(pop);
                
                q2sum -= pop;
                q1sum += pop;
                flag++;
            }
        }

        if(re == 1){
            return flag;
        }

        return -1;
    }
}