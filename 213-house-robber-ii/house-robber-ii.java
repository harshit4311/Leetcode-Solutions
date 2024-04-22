class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        // Calculate the maximum amount robbed up to each house 
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        
        // Store the maximum amount obtained without considering the FIRST house
        int maxWithoutFirst = dp[n - 2];
        
        // Reset DP array for the second pass
        dp[0] = 0;
        dp[1] = nums[1];
        
        // Calculate the maximum amount robbed up to each house 
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        
        // Store the maximum amount obtained without considering the LAST house
        int maxWithoutLast = dp[n - 1];
        
        return Math.max(maxWithoutFirst, maxWithoutLast);
    }
}