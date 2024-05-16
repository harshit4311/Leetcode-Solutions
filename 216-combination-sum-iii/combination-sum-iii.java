class Solution {
    public List<List<Integer>> combinationSum3(int n, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        helper(arr, 0, n, target, list, new ArrayList<>());
        return list;
    }

    public void helper(int[] arr, int i, int n, int target, List<List<Integer>> list, List<Integer> ds) {
        if(target == 0 && ds.size() == n) {
            list.add(new ArrayList<>(ds));
            return;
        }

        if(target < 0 || i == arr.length || ds.size() >= n) {
            return;
        }

        // Take the current element
        ds.add(arr[i]);
        helper(arr, i + 1, n, target - arr[i], list, ds);
        ds.remove(ds.size() - 1);

        // Don't take the current element
        helper(arr, i + 1, n, target, list, ds);
    }
}
