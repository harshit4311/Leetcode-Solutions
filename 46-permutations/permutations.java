class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        HashSet<Integer> visited = new HashSet<>();

        helper(arr, list, ds,visited);
        return list;
    }

    public void helper(int[] arr, List<List<Integer>> list, List<Integer> ds, HashSet<Integer> visited) {
        if(ds.size() == arr.length) {
            list.add(new ArrayList<>(ds));
            return; // Backtrack
        }

        for(int i = 0; i < arr.length; i++) {
            if(!visited.contains(i)) {
                visited.add(i);
                ds.add(arr[i]);

                helper(arr, list, ds, visited);
                
                ds.remove(ds.size() - 1);
                visited.remove(i);
            }
        }
    }
}