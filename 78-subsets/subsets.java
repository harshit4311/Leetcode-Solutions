class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        helper(0, new ArrayList<>(), arr, list);
        return list;
    }

    public void helper(int index, List<Integer> current, int[] arr, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current)); // Add a copy of current list to the result
            return;
        }

        // Include the current element
        current.add(arr[index]);
        helper(index + 1, current, arr, result);

        // Exclude the current element
        current.remove(current.size() - 1);
        helper(index + 1, current, arr, result);
    }
}