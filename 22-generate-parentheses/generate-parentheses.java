class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        helper(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    public void helper(List<String> result, StringBuilder sb, int left, int right, int n) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if(left < n) {
            sb.append("(");
            helper(result, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(left > right) {
            sb.append(")");
            helper(result, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}