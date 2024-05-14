class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        
        List<List<Integer>> list = new ArrayList<>();

        helper(0, arr, list, new ArrayList<>());
        return list;
    }

    public void helper(int start, int[] arr, List<List<Integer>> list, List<Integer> ds) {
        list.add(new ArrayList<>(ds));

        for(int i = start; i < arr.length; i++) {
            
            // Remove all duplicates
            if(i > start && arr[i] == arr[i - 1]) {
                continue;
            }

            ds.add(arr[i]);
            helper(i + 1, arr, list, ds);
            ds.remove(ds.size() - 1);
        }
    }
}