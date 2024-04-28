class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        backtrack(arr, target, 0, current, result);
        return result;
    }

    public void backtrack(int[] arr, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index == arr.length) {
            return;
        }

        // Case 1: Include current element
        current.add(arr[index]);
        backtrack(arr, target - arr[index], index, current, result);
        current.remove(current.size() - 1);

        // Case 2: Exclude current element and move to next
        backtrack(arr, target, index + 1, current, result);
    }
}