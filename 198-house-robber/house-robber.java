class Solution {
    public int rob(int[] arr) {
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];

        int[] dp = new int[arr.length + 1];

        dp[0] = 0;
        dp[1] = arr[0];

        for(int i = 2; i <= arr.length; i++) {
            dp[i] = Math.max(arr[i - 1] + dp[i - 2], dp[i - 1]);
        }

        return dp[arr.length];
    }
}