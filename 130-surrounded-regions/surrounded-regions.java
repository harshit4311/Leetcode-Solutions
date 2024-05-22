class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

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

        // Traverse over Rows
        for (int i = 0; i < m; i++) {
            bfs(i, 0, board); // Traverse over First Row
            bfs(i, n - 1, board); // Traverse over Last Row
        }

        // Traverse over Columns
        for (int i = 0; i < n; i++) {
            bfs(0, i, board); // Traverse over First Column
            bfs(m - 1, i, board); // Traverse over Last Column
        }

        // Convert all 'O's that are not visited to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void bfs(int row, int col, char[][] board) {
        if(board[row][col] == 'O' && !visited[row][col]) {
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(row, col));
            visited[row][col] = true;

            while (!queue.isEmpty()) {
                Pair current = queue.poll();
                int r = current.row;
                int c = current.col;

                for (int i = 0; i < 4; i++) {
                    int newRow = r + d_row[i];
                    int newCol = c + d_col[i];

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                            !visited[newRow][newCol] && board[newRow][newCol] == 'O') {
                        queue.add(new Pair(newRow, newCol));
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }
    }
}
