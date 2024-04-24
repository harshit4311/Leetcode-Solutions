class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Fill the dp array with -1
        for(int i = 0; i <= m - 1; i++) {
            for(int j = 0; j <= n - 1; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(0, 0, m, n, dp);
    }

    public int helper(int i, int j, int m, int n, int[][] dp) {

        // We reached the last cell
        if(i == m - 1 && j == n - 1) { 
            return 1;
        }  

        // Array index out of bounds
        if(i >= m || j >= n) { 
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = helper(i + 1, j, m, n, dp);
        int right = helper(i, j + 1, m, n, dp);

        dp[i][j] = down + right;

        return dp[i][j];
    }
}