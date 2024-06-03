class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;
        int j = 0;

        int n = s.length();
        int m = t.length();

        while(i < n && j < m) {
            if(s.charAt(i) == t.charAt(j)) {
                j++; // Move pointer that's traversing over string-->T
            }
            i++;  // Move pointer that's traversing over string-->S
        }

        // Return the remaining letters of t that are not traversed yet
        return m - j;
    }
}