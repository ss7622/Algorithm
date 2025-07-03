import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        long[] watchTime = new long[400000]; // int -> long
        
        for (String log : logs) {
            StringTokenizer st = new StringTokenizer(log, "-");
            int startTime = toSec(st.nextToken());
            int endTime = toSec(st.nextToken());

            watchTime[startTime] += 1;
            watchTime[endTime] -= 1;
        }

        int playTime = toSec(play_time);

        for (int i = 1; i <= playTime; i++) {
            watchTime[i] += watchTime[i - 1];
        }

        for (int i = 1; i <= playTime; i++) {
            watchTime[i] += watchTime[i - 1];
        }

        int advTime = toSec(adv_time);

        long max = watchTime[advTime - 1];
        int re = 0;

        for (int i = advTime; i <= playTime; i++) {
            long curTime = watchTime[i] - watchTime[i - advTime];
            if (max < curTime) {
                max = curTime;
                re = i - advTime + 1;
            }
        }

        return Formatter(re);
    }

    public int toSec(String s) {
        StringTokenizer st = new StringTokenizer(s, ":");
        int a = Integer.parseInt(st.nextToken()) * 3600;
        a += Integer.parseInt(st.nextToken()) * 60;
        a += Integer.parseInt(st.nextToken());
        return a;
    }

    public String Formatter(long a) {
        String hour = String.format("%02d", a / 3600);
        a %= 3600;
        String min = String.format("%02d", a / 60);
        a %= 60;
        String sec = String.format("%02d", a);
        return hour + ":" + min + ":" + sec;
    }
}
