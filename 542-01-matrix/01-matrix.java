class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] newMatrix = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        BFS(queue, m, n, visited, newMatrix);
        return newMatrix;
    }

    public void BFS(Queue<Pair> queue, int m, int n, boolean[][] visited, int[][] newMatrix) {
        int[] d_row = {-1, 0, 1, 0};
        int[] d_col = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            int row = current.row;
            int col = current.col;

            for(int i = 0; i < 4; i++) {
                int new_row = row + d_row[i];
                int new_col = col + d_col[i];

                // Check if the new cell is within bounds and not visited
                // If yes, 
                // Update/Increment the distance by 1 
                if(new_row >= 0 && new_row < m && new_col >= 0 && new_col < n
                    && !visited[new_row][new_col]) {

                    // Incrementing the dist. by 1
                    newMatrix[new_row][new_col] = newMatrix[row][col] + 1;

                    // Mark the cell as visited and add it to the queue
                    visited[new_row][new_col] = true;
                    queue.add(new Pair(new_row, new_col));
                }
            }
        }
    }
}