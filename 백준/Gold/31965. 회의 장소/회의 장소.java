import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static long[] X, prefix;

    static long cost(int l, int r, int idx) {
        long leftSum = X[idx] * (idx - l) - (prefix[idx] - prefix[l]);
        long rightSum = (prefix[r+1] - prefix[idx+1]) - X[idx] * (r - idx);
        return leftSum + rightSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        X = new long[N];
        prefix = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            X[i] = Long.parseLong(st.nextToken());
            prefix[i+1] = prefix[i] + X[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            long L = Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());

            int l = Arrays.binarySearch(X, L);
            if(l < 0) l = -l - 1;

            int r = Arrays.binarySearch(X, R);
            if(r < 0) r = -r - 2;

            if (l > r) { sb.append(0).append("\n"); continue; }
            if (l == r) { sb.append(0).append("\n"); continue; }

            long minCost = Long.MAX_VALUE, maxCost = Long.MIN_VALUE;
            for(int j=l;j<=r;j++){
                long c = cost(l, r, j);
                minCost = Math.min(minCost, c);
                maxCost = Math.max(maxCost, c);
            }

            sb.append(maxCost - minCost).append("\n");
        }

        System.out.print(sb);
    }
}
