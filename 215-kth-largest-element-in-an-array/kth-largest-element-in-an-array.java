class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the first k elements of the array to the minHeap
        for(int i = 0; i < k; i++){
            minHeap.add(arr[i]);
        }

        // For the remaining elements, if they are larger than the root of the min heap,
        // replace the root with the current element
        for(int i = k; i < arr.length; i++){
            if(arr[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        // Returns the smallest no.of the minHeap 
        return minHeap.peek();
    }
}