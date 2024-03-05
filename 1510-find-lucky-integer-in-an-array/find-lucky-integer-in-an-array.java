class Solution {
    public int findLucky(int[] arr) {
        int max = -1; 

        Map<Integer, Integer> freqMap = new HashMap<>();
        
        // Count occurrences of each element and store them the HashMap
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Iterate through the HashMap to find the maximum lucky integer
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            if (num == freqMap.get(num)) {
                max = Math.max(max, num);
            }
        }
        return max;
    }
}
