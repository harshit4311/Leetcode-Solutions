class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
        int initialColor = grid[sr][sc];
        
        // If the initial color is the same as the new color, we will return the same(original grid) as no operation is to be performed
        if(initialColor == newColor) {
            return grid;
        }

        // Directions for moving up, right, down, and left
        int[] d_row = {-1, 0, 1, 0};
        int[] d_col = {0, 1, 0, -1};

        dfs(sr, sc, initialColor, newColor, grid, d_row, d_col);
        return grid;
    }

    public void dfs(int sr, int sc, int initialColor, int newColor, int[][] grid, int[] d_row, int[] d_col) {
        int m = grid.length;
        int n = grid[0].length;

        // Fill the current cell with the new color
        grid[sr][sc] = newColor;

        // Visit all the four directions
        for (int i = 0; i < 4; i++) {
            int new_row = sr + d_row[i];
            int new_col = sc + d_col[i];

            // Check if the new position is within the boundaries of the grid and is not colored yet
            if (new_row >= 0 && new_row < m && new_col >= 0 && new_col < n
                && grid[new_row][new_col] == initialColor) {
                dfs(new_row, new_col, initialColor, newColor, grid, d_row, d_col);
            } 
        }
    }
}