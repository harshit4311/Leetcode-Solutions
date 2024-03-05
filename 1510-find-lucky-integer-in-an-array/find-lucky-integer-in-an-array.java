class Solution {
    public int findLucky(int[] arr) {
        int ans = -1;
        int[] freq = new int[502];

        // Count occurrences of each element in the input array
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i]; 
            freq[index] = freq[index] + 1;
        }

        // Find the maximum lucky integer
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == i) {
                ans = i;
            }
        }
        return ans;
    }
}
