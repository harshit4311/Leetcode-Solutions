class Solution {
    int[] color;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];

        // Fill all cells with -1
        for(int i = 0; i < n; i++) {
            color[i] = -1;
        }

        // Check if the graph is Bipartite
        for(int i = 0; i < n; i++) {
            if(color[i] == -1) {
                if(DFS(i, graph, 0) == false) {
                    return false;
                } 
            } 
        }

        return true;
    }

    public boolean DFS(int node, int[][] graph, int currentColor) {
        color[node] = currentColor; // Fill the first node with currentColor

        for(int i = 0; i < graph[node].length; i++) {
            int neighbor = graph[node][i];

            if(color[neighbor] == -1) {
                if(!DFS(neighbor, graph, 1 - currentColor)) {
                    return false;
                }
            } 

            // If both, Neighbor and CurrentNode have the same color,
            // Graph is NOT Bipartite
            else if(color[neighbor] == color[node]) {
                return false;
            }
        }

        return true;
    }
}