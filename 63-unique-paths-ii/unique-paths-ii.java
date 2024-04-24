class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Dynamic programming array to store the number of unique paths
        int[][] dp = new int[m][n];

        // Initialize DP array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        // Start recursion from the top-left corner
        return helper(0, 0, m, n, dp, obstacleGrid);
    }

    public int helper(int i, int j, int m, int n, int[][] dp, int[][] obstacleGrid) {
        // Check for out-of-bounds
        if (i >= m || j >= n) return 0;

        // If reached the destination (bottom-right corner)
        if (i == m - 1 && j == n - 1) {
            // If there's an obstacle at the destination, return 0
            if (obstacleGrid[i][j] == 1) {
                return 0;
            } else {
                return 1;
            }
        }

        // If already calculated, return the value from DP array
        if (dp[i][j] != -1) return dp[i][j];

        // If there's an obstacle at the current position, mark it as 0 and return 0
        if (obstacleGrid[i][j] == 1) {
            dp[i][j] = 0;
            return 0;
        }

        // Calculate the number of unique paths recursively
        int right = helper(i + 1, j, m, n, dp, obstacleGrid);
        int down = helper(i, j + 1, m, n, dp, obstacleGrid);

        // Store the calculated value in DP array
        dp[i][j] = right + down;

        return dp[i][j];
    }
}