class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return n;

        int prev = 1;
        int current = 1;
    
        for(int i = 2; i <= n; i++){
            int temp = current;
            current = prev + current;
            prev = temp;
        }

        return current;
    }
}