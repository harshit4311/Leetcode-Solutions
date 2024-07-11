class Solution {
    public int findKthLargest(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < n; i++) {
            maxHeap.add(arr[i]);
        }

         // Extract the maximum element k-1 times
        for(int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        
        // The next extraction will be the k-th largest element
        return maxHeap.poll();
    }
}