class Pair {
    int row;
    int column;
    int time;

    Pair(int row, int column, int time) {
        this.row = row;
        this.column = column;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        int countFresh = 0;

        // Initialize the queue with all rotten oranges and count fresh oranges
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                }

                if(grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        int time = 0;

        int[] d_row = {-1, 0, 1, 0};
        int[] d_col = {0, 1, 0, -1};

        int count = 0;

        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            int r = current.row;
            int c = current.column;
            int t = current.time;

            time = Math.max(time, t);

            for(int i = 0; i < 4; i++) {
                int n_row = r + d_row[i];
                int n_col = c + d_col[i];

                if(n_row >= 0 && n_row < n && n_col >= 0 && n_col < m
                    && grid[n_row][n_col] == 1) {
                    
                    grid[n_row][n_col] = 2;
                    queue.add(new Pair(n_row, n_col, t + 1));
                    count++;
                }
            }
        }

        // If all fresh oranges have been rotted, return the time, otherwise return -1(if not possble to rot all the oranges)
        if(count != countFresh) {
            return -1;
        }

        return time;
    }
}