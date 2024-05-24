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

        // Add all zero cells to the queue and mark them as visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        // Call the BFS function to update distances
        bfs(queue, m, n, visited, newMatrix);
        return newMatrix;
    }

    public void bfs(Queue<Pair> queue, int m, int n, boolean[][] visited, int[][] newMatrix) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int row = current.row;
            int col = current.col;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check if the new cell is within bounds and not visited
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    
                    // Update the distance in the newMatrix
                    newMatrix[newRow][newCol] = newMatrix[row][col] + 1;
                    // Mark the cell as visited and add it to the queue
                    visited[newRow][newCol] = true;
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}
