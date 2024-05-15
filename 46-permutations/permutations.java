class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];

        helper(arr, list, ds, freq);
        return list;
    }

    public void helper(int[] arr, List<List<Integer>> list, List<Integer> ds, boolean[] freq) {
        if(ds.size() == arr.length) {
            list.add(new ArrayList<>(ds));
            return;
        } // Backtrack

        for(int i = 0; i < arr.length; i++) {

            // If not marked as 'added' or 'true' in our 'ds'
            if(!freq[i]) {
                freq[i] = true; // Mark this is added in the 'ds'

                ds.add(arr[i]); // Add in the 'ds'
                helper(arr, list, ds, freq); // Op

                ds.remove(ds.size() - 1); // Remove from the 'ds'
                freq[i] = false; // Mark it as not added
            }
        }

    }
}