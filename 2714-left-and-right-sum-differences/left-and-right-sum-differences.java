class Solution {
    public int[] leftRightDifference(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 0;
        right[n - 1] = 0;

        for(int i = 1; i < n; i++) {
            left[i] = left[i - 1] + arr[i - 1];
        }

        for(int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + arr[i + 1];
        }

        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            ans[i] = Math.abs(left[i] - right[i]);
        }

        return ans;
    } 
}