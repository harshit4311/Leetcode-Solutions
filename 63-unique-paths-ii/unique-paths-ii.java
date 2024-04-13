class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];

        // Initialize the first cell
        if(obstacleGrid[0][0] == 1) {
            dp[0][0] = 0;
        } 
        else {
            dp[0][0] = 1;
        }

        // Find no.of paths for the first row
        for(int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
            else {
                dp[i][0] = 0;
            }
        }

        // Find no.of paths for the first columnn
        for(int j = 1; j < cols; j++) {
            if(obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            }
            else {
                dp[0][j] = 0;
            }
        }

        // Adding the no.of paths 
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i -1][j] + dp[i][j - 1];
                }
                else {
                    dp[i][j] = 0; // If the cell is an obstacle, no paths are possible
                }
            }
        }

        return dp[rows -1][cols - 1];
    }
}