class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int initialColor = grid[sr][sc];

        if(initialColor == color) {
            return grid;
        }

        int[] d_row = {-1, 0, 1, 0};
        int[] d_col = {0, 1, 0, -1};

        helperDFS(sr, sc, initialColor, color, d_row, d_col, grid);
        return grid;
    }

    public void helperDFS(int sr, int sc, int initialColor, int color, int[] d_row, int[] d_col, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Fill the cell with the newColor that has to be appplied to all cells
        grid[sr][sc] = color; 

        for(int i = 0; i < 4; i++) {
            int newRow = sr + d_row[i];
            int newCol = sc + d_col[i];

            if(newRow >= 0 && newRow <= m - 1 && newCol >= 0 && newCol <= n - 1  
                && grid[newRow][newCol] == initialColor) {
                    helperDFS(newRow, newCol, initialColor, color, d_row, d_col, grid);
            }
        }

    }
}