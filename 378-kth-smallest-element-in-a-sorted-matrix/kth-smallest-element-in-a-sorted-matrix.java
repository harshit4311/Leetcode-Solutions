import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Flatten the matrix and add elements to the min heap
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                pq.add(matrix[i][j]);
            }
        }

        // Remove the first k - 1 elements
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        // Return the kth smallest element
        return pq.peek();
    }
}
