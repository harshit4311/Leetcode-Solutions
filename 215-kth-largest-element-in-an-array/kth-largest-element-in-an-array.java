class Solution {
    public int findKthLargest(int[] arr, int k) {
        Arrays.sort(arr);

        int n = arr.length;
        return arr[n - k];
    }
}