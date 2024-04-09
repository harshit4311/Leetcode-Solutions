import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsequences(0, arr, new ArrayList<>(), result);
        return result;
    }
    
    public void generateSubsequences(int index, int[] arr, List<Integer> current, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Include current element
        current.add(arr[index]);
        generateSubsequences(index + 1, arr, current, result);
        
        // Exclude current element
        current.remove(current.size() - 1);
        generateSubsequences(index + 1, arr, current, result);
    }
}
