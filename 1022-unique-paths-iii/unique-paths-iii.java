class Solution {
    int m;
    int n;
    int result;
    int nonObstacleCount;
    
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        nonObstacleCount = 0;
        result = 0;

        int start_i = 0;
        int start_j = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    nonObstacleCount++;
                }

                if(grid[i][j] == 1) {
                    start_i = i;
                    start_j = j;
                    nonObstacleCount++;
                }
            }
        }

        int visitedCount = 0;

        helper(start_i, start_j, visitedCount, grid);
        return result;
    }

    public void helper(int i, int j, int visitedCount, int[][] grid) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) { // Array index out of bounds
            return;
        }

        if(grid[i][j] == 2) {
            if(visitedCount == nonObstacleCount) {
                result++;
            }
        }

        // Mark the cell as visited
        int temp = grid[i][j];
        grid[i][j] = -1;
        visitedCount++;

        // Explore all 4 directions
        for(int d = 0; d < directions.length; d++) {
            int new_i = directions[d][0] + i;
            int new_j = directions[d][1] + j;

            helper(new_i, new_j, visitedCount, grid);
        }

        // Backtrack
        grid[i][j] = temp; 
    }
}