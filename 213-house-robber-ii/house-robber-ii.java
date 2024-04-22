class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // Rob the first house and skip the last house
        int robFirst = robHelper(nums, 0, nums.length - 2);

        // Skip the first house and rob the last house
        int robLast = robHelper(nums, 1, nums.length - 1);

        return Math.max(robFirst, robLast);
    }

    public int robHelper(int[] nums, int start, int end) {
        int prevRob = 0; 
        int prevNotRob = 0; 
        
        for (int i = start; i <= end; i++) {
            int currentRob = prevNotRob + nums[i]; // Robbing the current house
            int currentNotRob = Math.max(prevRob, prevNotRob); // Not robbing the current house
            
            // Update previous values for the next iteration
            prevNotRob = currentNotRob;
            prevRob = currentRob;
        }
        
        return Math.max(prevRob, prevNotRob);
    }
}
