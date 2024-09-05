class Solution {
    int[] dp;
    public int rob(int[] arr) {
        int n = arr.length;

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper(arr, 0);
    }

    public int helper(int[] arr, int i) {
        int n = arr.length;

        if(i >= n) {
            return 0; 
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int steal = arr[i] + helper(arr, i + 2);
        int skip = helper(arr, i + 1);

        dp[i] = Math.max(steal, skip);
        return dp[i];
    }
}