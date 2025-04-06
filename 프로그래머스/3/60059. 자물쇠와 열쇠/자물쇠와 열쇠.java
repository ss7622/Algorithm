class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        int size = n + m * 2;

        int[][] board = new int[size][size];

        // lock을 board 중앙에 위치시킴
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i + m][j + m] = lock[i][j];
            }
        }

        // key 회전 4번
        for (int rot = 0; rot < 4; rot++) {
            key = rotate(key);

            for (int x = 0; x <= size - m; x++) {
                for (int y = 0; y <= size - m; y++) {
                    // key를 복사해서 board에 적용
                    int[][] copy = deepCopy(board);

                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            copy[x + i][y + j] += key[i][j];
                        }
                    }

                    if (checkCenter(copy, m, n)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // 회전
    public int[][] rotate(int[][] key) {
        int m = key.length;
        int[][] res = new int[m][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                res[i][j] = key[m - j - 1][i];
        return res;
    }

    // lock 영역 확인
    public boolean checkCenter(int[][] board, int offset, int size) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (board[i + offset][j + offset] != 1)
                    return false;
        return true;
    }

    // 깊은 복사
    public int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++)
            copy[i] = arr[i].clone();
        return copy;
    }
}
