// Top-Down (Recursion + Memoization approach)

class Solution {
    public int fib(int n) {
        if(n < 2) return n;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solveDp(n, dp);
    }

    public int solveDp(int n, int[] dp) {
        if(n < 2) return n;

        if(dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = solveDp(n - 1, dp) + solveDp(n - 2, dp);
    }
}