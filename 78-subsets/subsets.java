class Solution {
    public List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] arr) {
        List<Integer> temp = new ArrayList<>();
        solve(arr, 0, temp);
        return result;
    }

    public void solve(int[] arr, int i, List<Integer> temp) {
        if(i >= arr.length) { // Base Case
            result.add(new ArrayList<>(temp));
            return;
        }   
        
        temp.add(arr[i]);
        solve(arr, i + 1, temp);

        temp.remove(temp.size() - 1);
        solve(arr, i + 1, temp);
    }
}