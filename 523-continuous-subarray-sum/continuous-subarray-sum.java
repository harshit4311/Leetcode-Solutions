class Solution {
    public boolean checkSubarraySum(int[] arr, int k) {
        int n = arr.length;

        if(arr.length < 2) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];

            int remainder = sum % k;

            // Handle negative remainders by making them positive
            if (remainder < 0) {
                remainder += k;
            }

            // Check if the remainder has been seen before
            if (map.containsKey(remainder)) {
                // If the current subarray length is at least 2, return true
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            }  
            else { // Remainder not seen before, store the current index in the map
                map.put(remainder, i);
            }
        }

        return false;
    }
}