class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(1, n, k, temp);
        return result;
    }

    public void solve(int start, int n, int k, List<Integer> temp) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (start > n) // No more elements available
            return;

        temp.add(start); // Include the current element in the combination
        solve(start + 1, n, k - 1, temp); // Recursive call to generate combinations with the current element
        temp.remove(temp.size() - 1); // Backtrack: remove the last element to explore other combinations
        solve(start + 1, n, k, temp); // Recursive call to generate combinations without the current element
    }
}
