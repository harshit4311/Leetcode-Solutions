class Solution {
    public void reverseString(char[] string) {
        reverseHelper(string, 0, string.length - 1);
    }

    public void reverseHelper(char[] string, int start, int end) {
        if(start >= end) return;

        swap(string, start, end);
        reverseHelper(string, start + 1, end - 1);
    }

    public void swap(char[] string, int i, int j) {
        char temp = string[i];
        string[i] = string[j];
        string[j] = temp;
    }
}