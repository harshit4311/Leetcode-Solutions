class Solution {
    public int countNegatives(int[][] matrix) {
        int noOfRows = matrix.length;
        int noOfColumns = matrix[0].length;

        int row = 0;
        int column = noOfColumns - 1;

        int count = 0;
        
        while(row < noOfRows && column >= 0){
            if(matrix[row][column] < 0){
                count += (noOfRows - row);
                column--;
            }
            else{
                row++;
            }
        }
        return count;
    }
}