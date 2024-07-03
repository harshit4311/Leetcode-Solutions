class Solution {
    public int minDifference(int[] arr) {
        if(arr.length <= 4) {
            return 0;
        }

        Arrays.sort(arr);

        // Calculate result (min_difference)
        int result = arr[arr.length - 1] - arr[0];

        for(int i = 0; i <= 3; i++) {
            result = Math.min(result, arr[arr.length - (3 - i) - 1] - arr[i]);
        }

        return result;
    }
}