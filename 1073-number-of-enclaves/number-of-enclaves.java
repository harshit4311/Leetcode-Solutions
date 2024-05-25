class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    boolean[][] visited;
    int count;

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length; 

        visited = new boolean[m][n]; 

        // Traverse over all Columns (first and last columns of each row)
        for(int i = 0; i < m; i++) {
            
            if(grid[i][0] == 1 && !visited[i][0]) { // First Column
                BFS(i, 0, visited, grid);
            }

            if(grid[i][n - 1] == 1 && !visited[i][n - 1]) { // Last Column
                BFS(i, n - 1, visited, grid);
            }
        }

        // Traverse over all Rows (first and last rows of each column)
        for(int j = 0; j < n; j++) {

            if(grid[0][j] == 1 && !visited[0][j]) { // First row
                BFS(0, j, visited, grid);
            }

            if(grid[m - 1][j] == 1 && !visited[m - 1][j]) { // Last Row
                BFS(m - 1, j, visited, grid);
            }
        }

        count = 0;

        // Count the number of unvisited land cells
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public void BFS(int startRow, int startCol, boolean[][] visited, int[][] grid) {
        int[] d_row = {-1, 0, 1, 0};
        int[] d_col = {0, 1, 0, -1};

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startRow, startCol));
        visited[startRow][startCol] = true;

        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            int row = current.row;
            int col = current.col;

            // Traverse in all 4 directions
            for(int i = 0; i < 4; i++) {
                int new_row = row + d_row[i];
                int new_col = col + d_col[i];

                if(new_row >= 0 && new_row < m && new_col >= 0 && new_col < n
                        && grid[new_row][new_col] == 1 && !visited[new_row][new_col]) {
                    visited[new_row][new_col] = true;
                    queue.add(new Pair(new_row, new_col));
                }
            }
        }
    }

}
