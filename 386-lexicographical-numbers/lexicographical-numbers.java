class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    public void dfs(int currentElement, int n, List<Integer> result) {
        if(currentElement > n) {
            return;
        }

        result.add(currentElement);

        for(int i = 0; i < 10; i++) {
            dfs(currentElement * 10 + i, n, result);
        }
    }
}