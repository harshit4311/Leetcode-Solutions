class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // its an NxN matrix, so no.of rows = no.of columns

        boolean[] visited = new boolean[n];

        int provinceCount = 0;

        for(int i = 0; i < n; i++) {

            // If the city has not been visited, we have found a new province and we increment the counter
            if(!visited[i]) {
                provinceCount++;
                bfs(i, visited, isConnected);
            }
        }

        return provinceCount;
    }

    public void bfs(int start, boolean[] visited, int[][] isConnected) {
        int n = isConnected.length;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visited[start] = true;

        while(!queue.isEmpty()) {
            int city = queue.poll();

            for(int i = 0; i < n; i++) {

                // If there is a connection between cities and the city has not been visited yet
                if(isConnected[city][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                } 
            }
        }
    }
}