class Solution {
    int count = 0;

    public int findTargetSumWays(int[] arr, int target) {
        helper(arr, 0, 0, target);
        return count;
    }

    public int helper(int[] arr, int i, int currentSum, int target) {
        if(i == arr.length) {
            if(currentSum == target) {
                count++;
            }
        }

        else {

            // Negative(-ve) sign before taking an element
            helper(arr, i + 1, currentSum + arr[i], target); 

            // Positive(+ve) sign before taking an element
            helper(arr, i + 1, currentSum - arr[i], target);
        }

        return count;
    }
}