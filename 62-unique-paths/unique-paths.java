class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(m, n, 0, 0, dp);
    }

    public static int helper(int m, int n, int i, int j, int[][] dp) {
        // Base Cases
        if(i >= m || j >= n) return 0;
        if(i == m -1 || j == n -1) return 1; // This is the last row/column and there's just 1 option left

        if(dp[i][j] != 0) {
            return dp[i][j];
        }

        dp[i][j] = helper(m, n, i + 1, j, dp) + helper(m, n, i, j + 1, dp);

        return dp[i][j];
    }
}