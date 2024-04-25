class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();

        // Fill the dp List with -1
        for(int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                row.add(-1);
            }
            dp.add(row);
        }

        return helper(0, 0, dp, triangle);
    }

    public int helper(int row, int column, List<List<Integer>> dp , List<List<Integer>> triangle) {
        if(row == triangle.size() - 1) {
            return triangle.get(row).get(column);
        }

        if(dp.get(row).get(column) != -1) {
            return dp.get(row).get(column);
        }

        int down = helper(row + 1, column, dp, triangle);
        int rightDiagonal = helper(row + 1, column + 1, dp, triangle);

        // Store the result in dp
        dp.get(row).set(column, Math.min(down, rightDiagonal) + triangle.get(row).get(column));
        return dp.get(row).get(column);
    }
}