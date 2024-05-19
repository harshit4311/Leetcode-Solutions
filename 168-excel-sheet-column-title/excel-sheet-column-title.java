class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while(columnNumber > 0) {
            columnNumber--; // Adjust columnNumber to make it 0-indexed

            int remainder = columnNumber % 26;
            result.append((char) (remainder + 'A')); // Convert to its corresponding character
            
            columnNumber = columnNumber / 26;
        }

        return result.reverse().toString(); // Reverse to get the correct order
    }
}
