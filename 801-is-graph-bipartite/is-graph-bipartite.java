class Solution {
    int n;
    int[] color;

    public boolean isBipartite(int[][] graph) {
        n = graph.length;
        color = new int[n];

        // Fill all nodes with -1, depicting--> uncolored nodes
        for(int i = 0; i < n; i++) {
            color[i] = -1;
        }

        // Check if it's a bipartite graph
        for(int i = 0; i < n; i++) {
            if(color[i] == -1) {
                if(BFS(i, graph) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean BFS(int start, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;  // Start coloring the nodes with 0 

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for(int i = 0; i < graph[node].length; i++) { // graph[node] gives you the list of nodes that are directly connected to node
            // graph[0] returns {1, 3}. That means nodes -> 1 and 3 are connected to node -> 0

                int neighbor = graph[node][i]; // Access the 'i'th neighbor of the node

                // If the neighbor has not been colored, color it with the opposite color
                if(color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } 

                // If 2 neighbors have the same color
                else if(color[neighbor] == color[node]) { 
                    return false;
                }
            }
        }
        return true;
    }
}
