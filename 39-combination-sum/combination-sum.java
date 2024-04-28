class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        helper(0, arr, target, current, result);
        return result;
    }

    public void helper(int i, int[] arr, int target, List<Integer> current, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if(target < 0 || i == arr.length) {
            return;
        }

        // Case 1: Include current element
        current.add(arr[i]);
        helper(i, arr, target - arr[i], current, result);
        current.remove(current.size() - 1);

        // Case 2: Exclude current element and move to next
        helper(i + 1, arr, target, current, result);
    }
}
