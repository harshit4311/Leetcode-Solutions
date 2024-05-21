class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();

        helper(0, arr, list, new ArrayList<>());
        return list;
    }

    public void helper(int i, int[] arr, List<List<Integer>> list, List<Integer> ds) {
        if(i == arr.length) {
            list.add(new ArrayList<>(ds));
            return;
        }

        // Take
        ds.add(arr[i]);
        helper(i + 1, arr, list, ds); // Move to the next element as we don't want duplicates
        ds.remove(ds.size() - 1);

        // Don't Take
        helper(i + 1, arr, list, ds); // Move to the next element
    }
}