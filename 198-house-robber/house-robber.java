public class Solution {
    int[] dp = new int[101];

    public int rob(int[] arr) {
        Arrays.fill(dp, -1);
        return solve(arr, 0);
    }

    public int solve(int[] arr, int i) {
        if (i >= arr.length) return 0;
        if (dp[i] != -1) return dp[i];

        int steal = arr[i] + solve(arr, i + 2); // steal this house and move to the alternate houses
        int skip = solve(arr, i + 1); // skip this house and move to the next house

        return dp[i] = Math.max(steal, skip);
    }

}
