class Solution {
    int m;
    int n;
    boolean[][] visited;
    int[] d_row = {-1, 0, 1, 0};
    int[] d_col = {0, 1, 0, -1};

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        // Traverse over the borders using BFS
        for (int i = 0; i < m; i++) {
            bfs(i, 0, board);
            bfs(i, n - 1, board);
        }

        for (int j = 0; j < n; j++) {
            bfs(0, j, board);
            bfs(m - 1, j, board);
        }

        // Convert 'O's that are not visited to 'X's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(int row, int col, char[][] board) {
        if (board[row][col] == 'O' && !visited[row][col]) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{row, col});
            visited[row][col] = true;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for(int i = 0; i < 4; i++) {
                    int newRow = r + d_row[i];
                    int newCol = c + d_col[i];

                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                            !visited[newRow][newCol] && board[newRow][newCol] == 'O') {
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }
    }
}
