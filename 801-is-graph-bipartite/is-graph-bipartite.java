class Solution {
    int[] color;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];

        for(int i = 0; i < n; i++) {
            color[i] = -1;
        }

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
        color[node] = currentColor;  // Color the node with the currentColor
        
        for(int i = 0; i < graph[node].length; i++) {
            int neighbor = graph[node][i];

            if(color[neighbor] == -1) {
                if(!DFS(neighbor, graph, 1 - currentColor)) {
                    return false;
                }

            } 
            else if(color[neighbor] == color[node]) {
                return false;
            }
        }

        return true;
    }
}