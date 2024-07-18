class Solution {
    public int kthSmallest(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements to the PriorityQueue in row-wise + sorted order
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                minHeap.add(A[i][j]);
            }
        }

        // Remove (B - 1) elements from PriorityQueue
        for(int i = 1; i < B; i++) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}