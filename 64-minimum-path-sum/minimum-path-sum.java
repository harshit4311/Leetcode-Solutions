class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; // Rows
        int n = grid[0].length; // Columns

        int[][] dp = new int[m][n];

        // Fill the dp grid with -1
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(0, 0, m, n, grid, dp);
    }

    public int helper(int i, int j, int m, int n, int[][] grid, int[][] dp) {
        // Base
        // Pruning
        // Check
        // Process
        // Store
        // Return

        if (i == m - 1 && j == n - 1) return grid[i][j]; // Reached the end of the grid
        if (i >= m || j >= n) return Integer.MAX_VALUE; // Array index of bounds
        if(dp[i][j] != -1) return dp[i][j]; // Check

        int right = helper(i, j + 1, m, n, grid, dp);
        int down = helper(i + 1, j, m, n, grid, dp);

        dp[i][j] = Math.min(right, down) + grid[i][j];

        return dp[i][j];
    }

}