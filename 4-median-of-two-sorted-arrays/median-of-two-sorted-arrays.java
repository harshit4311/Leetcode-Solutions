class Solution {
    public double findMedianSortedArrays(int nums1[], int nums2[]) {

        int n = nums1.length;
        int m = nums2.length;

        int mergedArr[] = new int[n + m];
        int k = 0;

        // Merging nums1
        for (int i = 0; i < n; i++) {
            mergedArr[k++] = nums1[i];
        }

        // Merging nums2
        for (int i = 0; i < m; i++) {
            mergedArr[k++] = nums2[i];
        }

        Arrays.sort(mergedArr);

        int length = mergedArr.length;

        // When length is odd
        if (length % 2 == 1) {
            return (double) mergedArr[length / 2];
        } 

        // When length is even
        else {
            int middle1 = mergedArr[length / 2 - 1];
            int middle2 = mergedArr[length / 2];
            return ((double) middle1 + (double) middle2) / 2.0;
        }
    }
}