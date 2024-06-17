class Solution {
    int m;
    int n;
    int result;
    int nonObstacles;
    
    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        result = 0;
        nonObstacles = 0;
        
        int start_i = 0;
        int start_j = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    nonObstacles++;
                }
                
                if(grid[i][j] == 1) {
                    start_i = i;
                    start_j = j;
                    nonObstacles++; // Counting starting point as nonObstacle
                }
            }
        }
        
        int count = 0;
        
        helper(start_i, start_j, count, grid);
        return result;
    }
    
    public void helper(int i, int j, int count, int[][] grid) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return;
        }
        
        if(grid[i][j] == 2) {
            if(count == nonObstacles) {
                result++;
            }
            return;
        }
        
        // Mark cell as visited
        int temp = grid[i][j];
        grid[i][j] = -1;
        count++;
        
        // Explore in all 4 directions
        for(int d = 0; d < directions.length; d++) {
            int new_i = i + directions[d][0];
            int new_j = j + directions[d][1];
            
            helper(new_i, new_j, count, grid);
        }
        
        // Backtrack
        grid[i][j] = temp;
    }
}
