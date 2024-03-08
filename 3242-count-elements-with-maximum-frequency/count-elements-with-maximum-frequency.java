class Solution {
    public int maxFrequencyElements(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies of each element in the array
        for (int num : arr) {
            // Increment the frequency of the current number in the map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        int maxFreq = Integer.MIN_VALUE;

        // Find the maximum frequency among all elements
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // Count the total occurrences of elements with maximum frequency
        for (int freq : map.values()) {
            if (freq == maxFreq)
                count += maxFreq;
        }

        return count; 
    }
}