class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        // Base Case : When t is empty, there is one subsequence in s
        for(int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {

                // If characters match, we can either include or exclude the character from s
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } 
                else { // If characters don't match, we can only exclude the character from s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[s.length()][t.length()];
    }
}