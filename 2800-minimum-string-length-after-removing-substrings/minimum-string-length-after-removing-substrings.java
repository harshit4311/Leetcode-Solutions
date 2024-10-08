class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char current_char = s.charAt(i);

            // empty
            if(stack.isEmpty()) {
                stack.push(current_char);
                continue;
            }

            // AB
            if(current_char == 'B' && stack.peek() == 'A') {
                stack.pop();
            }

            // CD
            else if(current_char == 'D' && stack.peek() == 'C') {
                stack.pop();
            }

            else {
                stack.push(current_char);
            }
        }
        return stack.size();
    }
}