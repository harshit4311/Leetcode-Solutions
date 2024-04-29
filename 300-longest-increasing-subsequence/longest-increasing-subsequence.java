class Solution {
    public int lengthOfLIS(int[] arr) {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            int start = 0;
            int end = maxLength;

            while (start < end) {
                int mid = start + (end - start) / 2;
                
                if (arr[mid] < arr[i]) start = mid + 1;
                else end = mid;
            }   
            arr[start] = arr[i];

            // If we reach the end, increment the maxLength
            if (start == maxLength) maxLength++;
        }
        return maxLength;
    }
}
