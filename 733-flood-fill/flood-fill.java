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

        // Fill the current cell with newColor
        grid[sr][sc] = newColor;

        // Traverse in all 4 directions
        for(int i = 0; i < 4; i++) {
            int new_row = sr + d_row[i]; // New Row Index
            int new_col = sc + d_col[i]; // New Column Index

            // Check if new Row & Column indices are within the boundaries 
            // and whether the current cell is still filled with the initialColor
            // If it is still filled with initialColor, fill newColor in it using DFS
            if(new_row >= 0 && new_row <= m - 1 && new_col >= 0 && new_col <= n - 1
                && grid[new_row][new_col] == initialColor) {
                    dfs(new_row, new_col, initialColor, newColor, grid, d_row, d_col);
                }
        }
    }
}