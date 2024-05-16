class Solution {
    public List<List<Integer>> combinationSum3(int n, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        helper(arr, 0, n, target, list, new ArrayList<>());
        return list;
    }

    public void helper(int[] arr, int i, int n, int target, List<List<Integer>> list, List<Integer> ds) {
         
        // Valid combination. So, we add it in our list
        if(target == 0 && ds.size() == n ) {
            list.add(new ArrayList<>(ds));
            return; // Backtrack to find another unique combination
        }

        // target < 0: If the target becomes negative, it means we've overshot the required sum, so we stop further exploration of this path.
        // i == arr.length: If i reaches the end of the array arr, it means we've explored all available elements, so we stop further recursion.
        // ds.size() >= n: If the size of the current combination ds becomes equal to or greater than n, it means we've used up more elements than allowed, so we stop further exploration of this path.
        if(target < 0 || i == arr.length || ds.size() >= n) {
            return; // Backtrack to find a valid combination
        }

        // Take the current element
        ds.add(arr[i]);
        helper(arr, i + 1, n, target - arr[i], list, ds);
        ds.remove(ds.size() - 1);

        // Don't take the current element
        helper(arr, i + 1, n, target, list, ds);
    }
}
