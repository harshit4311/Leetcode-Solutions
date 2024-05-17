class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> list = new ArrayList<>();

        helper(0, board, list);
        return list;
    }

    // Function to check if placing a queen at board[row][col] is valid
    public boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;

        // Check the upper left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;

        // Check the left side of the current row
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;

        // Check the lower left diagonal
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }

        // If no queens are found in any of our checked directions, the position is valid
        return true;
    }

    public void helper(int col, char[][] board, List<List<String>> list) {
        if(col == board.length) {
            list.add(construct(board));
            return; // Backtrack
        }

        for(int row = 0; row < board.length; row++) {
            if(validate(board, row, col)) { // If a valid position to place the queen
                board[row][col] = 'Q';

                helper(col + 1, board, list); // Move to the next column
                board[row][col] = '.'; // Remove the queen (Backtrack)
            }
        }
    }
    
    // Function to construct the current board configuration as a list of strings
    public List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }

}