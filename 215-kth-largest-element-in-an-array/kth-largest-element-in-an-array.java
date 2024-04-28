class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all arrray elements to the minHeap
        for(int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]); 
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        } 

        return minHeap.peek();
    }
}