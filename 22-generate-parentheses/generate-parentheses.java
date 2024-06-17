
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        generate(new StringBuilder(), n, 0, result);
        return result;
    }

    public void generate(StringBuilder str, int n, int length, List<String> result) {
        if(length == 2 * n) {
            if(isValid(str)) {
                result.add(str.toString());
            }
            return;
        }

        str.append('(');
        generate(str, n, length + 1, result);
        str.deleteCharAt(str.length() - 1); // Backtrack by removing the last character

        str.append(')');
        generate(str, n, length + 1, result);
        str.deleteCharAt(str.length() - 1); // Backtrack by removing the last character
    }

    public boolean isValid(StringBuilder str) {
        int totalSum = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                totalSum++;
            } 
            else {
                totalSum--;

                if (totalSum < 0) {
                    return false;
                }
            }
        }

        return totalSum == 0;
    }
}