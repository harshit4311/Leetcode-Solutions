class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize the bottom row to 1
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }

        // Initialize the rightmost column to 1
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }

        // Iterate through rows from bottom to top and columns from right to left
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        // Return the result which is stored in the top-left cell
        return dp[0][0];
    }
}
