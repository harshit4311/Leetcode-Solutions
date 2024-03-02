import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                pq.add(matrix[i][j]);

                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
}
