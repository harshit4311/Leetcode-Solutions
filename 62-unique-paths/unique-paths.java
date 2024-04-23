class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
    
        // Initially, fill the DP array with -1
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        } 

        return helper(0, 0, m, n, dp);
    }

    public int helper(int i, int j, int m, int n, int[][] dp) {
        if(i == m - 1 && j == n - 1) return 1; // We reached the end
        if(i >=m || j >= n) return 0; // Index out of bounds

        if(dp[i][j] != -1) return dp[i][j];

        int down = helper(i + 1, j, m, n, dp);
        int right = helper(i, j + 1, m, n, dp);

        dp[i][j] = down + right; // Memoize(Store) the result

        return dp[i][j];
    }
}