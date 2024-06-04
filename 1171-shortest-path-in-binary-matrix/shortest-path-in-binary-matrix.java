class Pair {
    int row;
    int col;
    int distance;

    Pair(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[n][n];

        // Perform BFS starting from top-left corner (0, 0)
        int distance = bfs(0, 0, visited, grid);

        return distance;
    }

    public int bfs(int r, int c, boolean[][] visited, int[][] grid) {
        int n = grid.length;

        Queue<Pair> queue = new LinkedList<>();

        visited[r][c] = true;
        queue.add(new Pair(r, c, 1)); // Include distance (1 initially since we start at (0, 0))

        int[] rowDirections = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] colDirections = {1, -1, 0, 0, 1, -1, 1, -1};

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            // Check if bottom-right corner is reached (destination)
            if (current.row == n - 1 && current.col == n - 1) {
                return current.distance;
            }

            for (int i = 0; i < 8; i++) {
                int newRow = current.row + rowDirections[i];
                int newCol = current.col + colDirections[i];

                // Check if new cell is within grid bounds, unvisited, and has value 0
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n 
                    && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {

                    visited[newRow][newCol] = true;
                    queue.add(new Pair(newRow, newCol, current.distance + 1)); // Update distance for next level
                }
            }
        }

        return -1;
    }
}