class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return DFS(adjList, visited, source, destination);
    }

    public boolean DFS(List<List<Integer>> adjList, boolean[] visited, int current, int destination) {
        if(current == destination) {
            return true;
        }

        visited[current] = true;

        // Explore neighbors of current node
        List<Integer> neighbors = adjList.get(current);

        for(int i = 0; i < neighbors.size(); i++) {
            int neighbor = neighbors.get(i);
            if(!visited[neighbor]) {
                if(DFS(adjList, visited, neighbor, destination)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}