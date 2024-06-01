class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] isVisited = new boolean[n];

        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                count++;
                DFS(i, isVisited, isConnected);
            }
        }

        return count;
    }

    public void DFS(int start, boolean[] isVisited, int[][] isConnected) {
        isVisited[start] = true;

        for(int i = 0; i < isConnected.length; i++) {

             // If there is a connection between cities and the city has not been visited yet
            if(isConnected[start][i] == 1 && !isVisited[i]) {
                DFS(i, isVisited, isConnected);
            }
        }
    }
}