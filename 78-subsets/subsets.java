class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(arr, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void generateSubsets(int[] arr, List<List<Integer>> result, List<Integer> temp, int index) {
        if (index == arr.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Include the current element
        temp.add(arr[index]);
        generateSubsets(arr, result, temp, index + 1);

        // Exclude the current element
        temp.remove(temp.size() - 1);
        generateSubsets(arr, result, temp, index + 1);
    }
}