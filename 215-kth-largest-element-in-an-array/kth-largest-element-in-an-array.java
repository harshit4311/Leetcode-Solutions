class Solution {
    public int findKthLargest(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        for(int i = k; i < n; i++) {
            if(arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        return minHeap.peek();
    }
}