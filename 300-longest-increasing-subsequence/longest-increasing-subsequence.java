class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];

        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            int start = 0;
            int end = max;
            int n = nums[i];

            while(start < end) {
                int mid = start + (end - start) / 2;
                
                if(arr[mid] < n) start = mid + 1;
                else end = mid;
            }
            arr[start] = n;

            // If we reach the end, increment the max
            if(start == max) max++;
        }

        return max;
    }
}