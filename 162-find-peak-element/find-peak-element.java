class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length - 1;

        if (n == 0) return 0;
        if (arr[0] > arr[1]) return 0;

        // Check if the last element is the peak
        if (arr[n] > arr[n - 1]) return n;

        // Search in the remaining array
        int start = 1;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Mid is greater than its neighbouring elements, it is a peak
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // If the element to the left of mid is greater, search in the left half
            if (arr[mid] < arr[mid - 1]) {
                end = mid - 1;
            }

            // If the element to the right of mid is greater, search in the right half
            else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            }
        }

        // No peak found
        return -1;
    }
}