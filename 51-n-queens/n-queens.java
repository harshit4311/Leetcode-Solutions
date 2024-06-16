class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(0, board, result);
        return result;
    }

    public void helper(int col, char[][] board, List<List<String>> result) {
        if(col == board.length) {
            result.add(constructBoard(board));
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(isValid(board, i, col)) {
                board[i][col] = 'Q';
                helper(col + 1, board, result);
                board[i][col] = '.'; // Backtrack
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col) {
        // Check the same row on the left side
        for(int j = 0; j < col; j++) {
            if(board[row][j] == 'Q') {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for(int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public List<String> constructBoard(char[][] board) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }

        return result;
    }
}
