class Solution {
    int l, m, n;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        l = word.length();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && find(board , i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, int i, int j, String word, int index) {
        if(index >= word.length()) 
        return true;

        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) 
        return false;

        char temp = board[i][j];
        board[i][j] = '$';

        for(int d = 0; d < directions.length; d++) {
            int new_i = i + directions[d][0];
            int new_j = j + directions[d][1];

            if(find(board, new_i, new_j, word, index + 1)) {
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }

}