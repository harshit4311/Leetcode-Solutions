class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();

        recurse(result, 0, 0, "", n);
        return result;
    }
    
    public void recurse(List<String> result, int start, int end, String s, int n) {
        if(s.length() == n * 2) {
            result.add(s);
            return;
        }
        
        if(start < n) {
            recurse(result, start + 1, end, s + "(", n);
        }
        
        if(end < start) {
            recurse(result, start, end + 1, s + ")", n);
        }
    }
}