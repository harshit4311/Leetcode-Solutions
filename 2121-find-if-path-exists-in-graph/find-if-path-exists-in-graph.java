class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }
    
        return uf.connected(source, destination);
    }
}

class UnionFind {
    int[] parent;
    int[] rank;
        
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
            }
        }
        
    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }

        return parent[x];
    }
        
    // Union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } 
            else if(rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } 
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
        
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}