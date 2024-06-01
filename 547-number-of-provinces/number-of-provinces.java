class UnionFind {
    int[] parent;
    int[] rank;
    int count;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        count = size;

        for(int i = 0; i < size; i++) {
            parent[i] = i; // Initially, parent of each node is the node itself
            rank[i] = 0;
        }
    }

    public int find(int p) {
        if(parent[p] != p) {
            parent[p] = find(parent[p]);
        }

        return parent[p];
    }

    public void union(int p, int q) {
        int rootP = find(p); // Find the root of P
        int rootQ = find(q); // Find the root of Q

        if(rootP != rootQ) {
            if(rank[p] > rank[q]) {
                parent[rootQ] = rootP;
            }

            else if(rank[p] < rank[q]) {
                parent[rootP] = rootQ;
            }

            else { // Ranks of poth, P and Q are the same 
                parent[rootQ] = rootP;
                rank[rootP]++;
            }

            count--;
        }
    }

    public int getCount() {
        return count;
    }

}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        UnionFind uf = new UnionFind(n);

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getCount();
    }
}