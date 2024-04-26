class Solution {
    public boolean canPartition(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if(sum % 2 != 0) return false;

        int halfSum = sum / 2;

        int[][] dp = new int[arr.length][halfSum + 1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return subsetSumEqualsTarget(arr.length, 0, halfSum, arr, dp);
    }

    public boolean subsetSumEqualsTarget(int n, int i, int target, int[] arr, int[][] dp) {
        return helper(n, i, target, arr, dp);
    }

    public boolean helper(int n, int i, int target, int[] arr, int[][] dp) {
        if (target == 0) return true; 
        if (i == n || target < 0) return false; 
        if (dp[i][target] != -1) return dp[i][target] == 1;

        boolean excludeCurrent = helper(n, i + 1, target, arr, dp);
        boolean includeCurrent = helper(n, i + 1, target - arr[i], arr, dp);

        if(excludeCurrent || includeCurrent) {
            dp[i][target] = 1; // If either excluding or including the current element leads to the target sum, mark as possible
        } 
        else {
            dp[i][target] = 0; // Otherwise, mark as impossible
        }

        return dp[i][target] == 1;
    }

}