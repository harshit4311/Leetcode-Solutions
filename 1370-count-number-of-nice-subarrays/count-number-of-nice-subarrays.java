class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);  // Initialize with 0 odd counts

        int oddCount = 0;
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 1) {
                oddCount++;
            }

            // If there exists a prefix subarray with (oddCount - k) odd numbers,
            // it means there is a subarray ending at the current position with exactly k odd numbers
            result += countMap.getOrDefault(oddCount - k, 0);

            // Update the countMap with the current oddCount
            countMap.put(oddCount, countMap.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }
}