class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Count degrees of each node
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            map.put(u, map.getOrDefault(u, 0) + 1);
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        
        int n = edges.length + 1; // Number of nodes in the graph
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n - 1) {
                return entry.getKey();
            }
        }
        
        return -1;
    }
}