class Solution {
    int m;
    int n;

    public int numIslands(char[][] grid) {

        // 0 Islands
        if(grid == null || grid.length == 0) {
            return 0; 
        }

        int islandCount = 0;

        m = grid.length;
        n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                // Found a new island
                if(grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j);
                }
            }
        }

        return islandCount;
    }

    public void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return; // Backtrack
        }

        grid[i][j] = '0'; // Mark as visited

        dfs(grid, i - 1, j); // Up
        dfs(grid, i, j + 1); // Right
        dfs(grid, i + 1, j); // Down
        dfs(grid, i, j - 1); // Left
    }
}