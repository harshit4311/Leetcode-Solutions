class Solution {
    public boolean isPalindrome(String string) {
        return isPalindrome(string, 0, string.length() - 1);
    }

    public boolean isPalindrome(String string, int start, int end) {
        if (start >= end) return true;

        char startChar = Character.toLowerCase(string.charAt(start));
        char endChar = Character.toLowerCase(string.charAt(end));

        // Skip non-alphanumeric characters
        if (!Character.isLetterOrDigit(startChar)) {
            return isPalindrome(string, start + 1, end);
        }
        if (!Character.isLetterOrDigit(endChar)) {
            return isPalindrome(string, start, end - 1);
        }

        // Compare characters
        if (startChar != endChar) return false;

        return isPalindrome(string, start + 1, end - 1);
    }
}