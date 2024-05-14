class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();

        helper(0, target, arr, new ArrayList<>(), list);
        return list;
    }

    public void helper(int i, int target, int[] arr, List<Integer> tempList, List<List<Integer>> list) {
        if(target == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        if(target < 0 || i >= arr.length) {
            return;
        }

        // Take the current index
        tempList.add(arr[i]);
        helper(i, target - arr[i], arr, tempList, list);
        tempList.remove(tempList.size() - 1); // Backtrack

        // Don't take the current index
        helper(i + 1, target, arr, tempList, list);
    }
}