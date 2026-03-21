import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static class Point {
        int z, y, x;
        Point(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로
        int H = Integer.parseInt(st.nextToken()); // 높이

        int[][][] board = new int[H][N][M];
        Queue<Point> queue = new LinkedList<>();

        int unripeCount = 0; // 익지 않은 토마토 개수

        // 데이터 입력 및 초기 상태 세팅
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) {
                        queue.add(new Point(i, j, k)); // 익은 토마토는 큐에 바로 삽입
                    } else if (board[i][j][k] == 0) {
                        unripeCount++; // 익지 않은 토마토 카운트
                    }
                }
            }
        }

        // 저장될 때부터 이미 다 익어있는 상태라면
        if (unripeCount == 0) {
            System.out.println(0);
            return;
        }

        int days = 0; // 걸린 일수

        // BFS 탐색 시작
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nz = current.z + dz[i];
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                // 창고 범위를 벗어나지 않고
                if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    // 익지 않은 토마토(0)라면
                    if (board[nz][ny][nx] == 0) {
                        // 이전 토마토의 일수 + 1을 저장
                        board[nz][ny][nx] = board[current.z][current.y][current.x] + 1;
                        queue.add(new Point(nz, ny, nx));
                        unripeCount--; // 익은 토마토 처리
                        days = Math.max(days, board[nz][ny][nx]); // 최대 일수 갱신
                    }
                }
            }
        }

        // 탐색이 끝났는데 여전히 익지 않은 토마토가 남아있다면
        if (unripeCount > 0) {
            System.out.println(-1);
        } else {
            // 시작을 1로 했으므로 총 일수에서 1을 빼줌
            System.out.println(days - 1);
        }
    }
}