class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i; // Each node is its own parent, initially
            rank[i] = 1; // Each node has a rank of 1, initially
        }
    }

    public int findParent(int node) {
        if(parent[node] != node) {
            parent[node] = findParent(parent[node]); // Path Compression
        }

        return parent[node];
    }

    public void unionByRank(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);

        if(rootU != rootV) {
            if(rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            }

            else if(rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            }

            else { // When ranks of both 'u' & 'v' are the same
                parent[rootV] = rootU;
                rank[rootU]++;
            }

        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        // Initial check for minimum number of edges required to connect all nodes
        if (connections.length < n - 1) {
            return -1; // Not enough edges to connect all computers
        }

        UnionFind uf = new UnionFind(n);
        int extraEdges = 0;

        int m = connections.length;
        
        for(int i = 0; i < m; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            if(uf.findParent(u) == uf.findParent(v)) {
                extraEdges++;
            } 
            else {
                uf.unionByRank(u, v);
            }
        }

        int countSeparateComponents = 0;
        for(int i = 0; i < n; i++) {
            if(uf.findParent(i) == i) { 
                countSeparateComponents++;
            }
        }

        int requiredEdges = countSeparateComponents - 1;
        if(extraEdges >= requiredEdges) {
            return requiredEdges;
        } 
        else {
            return -1;
        }
    }
}