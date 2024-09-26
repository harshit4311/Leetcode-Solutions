class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for(int i = 0; i < columnTitle.length(); i++) {
            int current_ASCII = columnTitle.charAt(i) - 'A' + 1; // val of current letter 

            result = result * 26 + current_ASCII;
        }
        return result;
    }
}