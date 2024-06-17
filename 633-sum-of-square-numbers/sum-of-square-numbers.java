class Solution {
    public boolean judgeSquareSum(int c) {
        long start = 0;
        long end = (long) Math.sqrt(c);

        while(start <= end) {
            long currentSumOfSquares = (start * start) + (end * end);

            if(currentSumOfSquares < c) {
                start++;
            }

            else if(currentSumOfSquares > c) {
                end--;
            }

            // currentSumOfSquares == c
            else {
                return true;
            }
        }

        return false;
    }
}