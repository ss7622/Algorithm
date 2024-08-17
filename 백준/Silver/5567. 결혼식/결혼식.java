import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt = 0;
    static boolean visited[];
    static List<ArrayList<Integer>> edge = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            edge.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edge.get(a).add(b);
            edge.get(b).add(a);
        }

        bfs();

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { 1, 0 });
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int depth = current[1];

            if (depth == 2) {
                continue; // 깊이 2를 넘으면 탐색을 중지
            }

            for (int neighbor : edge.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[] { neighbor, depth + 1 });
                    if (depth == 1 || depth == 0) {
                        cnt++; // 깊이 1인 노드들의 친구들만 카운트
                    }
                }
            }
        }
    }
}
