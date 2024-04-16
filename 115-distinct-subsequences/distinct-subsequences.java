class Solution {
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1; // Base case: when t is empty, there is one subsequence in s
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = t.length(); j > 0; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // If characters match, we can either include or exclude the character from s
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return dp[t.length()];
    }
}
