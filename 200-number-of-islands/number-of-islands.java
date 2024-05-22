class Pair {
    int r;
    int c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    int m;
    int n;
    boolean[][] visited;
    int islandCount = 0;
    int[] d_row = {-1, 0, 1, 0};
    int[] d_col = {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    public void bfs(char[][] grid, int r, int c) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r, c));
        visited[r][c] = true;

        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            int cur_row = current.r; // Get the row index of the current cell
            int cur_col = current.c; // Get the column index of the current cell

            // Explore all four possible directions
            for(int i = 0; i < 4; i++) {
                int new_row = cur_row + d_row[i];
                int new_col = cur_col + d_col[i];

                // Check if the new cell is within the grid bounds, unvisited, and part of the island
                if(new_row >= 0 && new_row < m && new_col >= 0 && new_col < n && 
                    !visited[new_row][new_col] && grid[new_row][new_col] == '1') {
                    queue.add(new Pair(new_row, new_col));
                    visited[new_row][new_col] = true;
                }
            }
        }
    }
}
