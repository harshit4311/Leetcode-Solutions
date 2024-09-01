class Solution {
    public int[][] construct2DArray(int[] arr, int m, int n) {
        if(arr.length != m * n) {
            return new int[0][0];
        }

        int[][] result = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = arr[i * n + j];
            }
        }
        return result;
    }
}