class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        // Fill the dp array with 1
        Arrays.fill(dp, 1);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[j] += dp[j + 1];
            }
        }

        // Return the result stored in the first cell
        return dp[0];
    }
}
