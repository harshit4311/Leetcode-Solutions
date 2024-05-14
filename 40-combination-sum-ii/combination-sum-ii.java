class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);

        List<List<Integer>> list = new ArrayList<>();

        helper(0, target, arr, list, new ArrayList<>());
        return list;
    }

    public void helper(int i, int target, int[] arr, List<List<Integer>> list, List<Integer> ds) {
        if(i == arr.length) {
            if(target == 0) {
                list.add(new ArrayList<>(ds));
            }
            return;
        }

        // Take 
        if(arr[i] <= target) {
            ds.add(arr[i]);
            helper(i + 1, target - arr[i], arr, list, ds);
            ds.remove(ds.size() - 1);
        }
        
        // Skip all duplicates
        while((i + 1 <= arr.length - 1) && (arr[i] == arr[i + 1])) {
            i++;
        }

        // Don't Take
        helper(i + 1, target, arr, list, ds);
    }
}