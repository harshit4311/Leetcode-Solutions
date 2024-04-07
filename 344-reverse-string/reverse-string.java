class Solution {
    public void reverseString(char[] string) {
        int start = 0;
        int end = string.length - 1;

        while(start <= end){
            char temp = string[start];
            string[start] = string[end];
            string[end] = temp;
            start++;
            end--;   
        }
    }
}