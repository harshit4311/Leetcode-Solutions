class Solution {
    int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return Math.min(helper(cost, n - 1), helper(cost, n - 2)); 
    }

    public int helper(int[] cost, int i) {
        if(i < 0) {
            return 0;
        }

        if(i == 0 || i == 1) {
            return cost[i];
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        dp[i] = cost[i] + Math.min(helper(cost, i - 1), helper(cost, i - 2));
        return dp[i];
    }
}