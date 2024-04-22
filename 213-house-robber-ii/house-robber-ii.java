class Solution {
    public int rob(int[] arr) {
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];
        if(arr.length == 2) return Math.max(arr[0], arr[1]);

        int robFirst = helper(arr, 0, arr.length - 2);
        int robLast = helper(arr, 1, arr.length - 1);

        return Math.max(robFirst, robLast);
    }

    public int helper(int[] arr, int start, int end) {
        int prevRob = 0;
        int prevNotRob = 0;

        for(int i = start; i <= end; i++) {
            int currentRob = prevNotRob + arr[i];
            int currentNotRob = Math.max(prevRob, prevNotRob);

            // Updating the previous values for the next iteration
            prevNotRob = currentNotRob;
            prevRob = currentRob;
        }

        return Math.max(prevRob, prevNotRob);
    }
}