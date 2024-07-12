class Solution {
    public int maximumGain(String s, int x, int y) {
        int score = 0;

        String firstPattern;
        String secondPattern;

        int firstPoints;
        int secondPoints;

        if(x > y) {
            firstPattern = "ab";
            firstPoints = x;
            secondPattern = "ba";
            secondPoints = y;
        } 
        else {
            firstPattern = "ba";
            firstPoints = y;
            secondPattern = "ab";
            secondPoints = x;
        }

        // First Pass
        s = removeAndCount(s, firstPattern, firstPoints);
        score += pointsGained;
        
        // Second Pass
        s = removeAndCount(s, secondPattern, secondPoints);
        score += pointsGained;

        return score;
    }

    int pointsGained = 0;

    public String removeAndCount(String s, String pattern, int points) {
        Stack<Character> stack = new Stack<>();
        pointsGained = 0;

        for (char ch : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == pattern.charAt(0) && ch == pattern.charAt(1)) {
                stack.pop(); // Remove the first character of the pattern
                pointsGained += points;
            } 
            else {
                stack.push(ch); // Add the current character to the stack
            }
        }
        
        // Rebuild the string after removing all instances of the pattern
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}