// LeetCode: Sudoku Solver (sudoku-solver)
// Submission ID: 1754384336
// Language: java
// Timestamp (UTC): 2025-08-31T05:50:09Z

class Solution {
    private static boolean rowCheck(int row, int col, int num, char[][] board) {
        for (int j = 0; j < 9; j++) {
            if (j == col) continue;
            if (board[row][j] - '0' == num) return false;
        }
        return true;
    }

    private static boolean colCheck(int row, int col, int num, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i == row) continue;
            if (board[i][col] - '0' == num) return false;
        }
        return true;
    }

    private static boolean gridCheck(int row, int col, int num, char[][] board) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (i == row && j == col) continue;
                if (board[i][j] - '0' == num) return false;
            }
        }
        return true;
    }

    private static boolean solve(int i, int j, char[][] board) {
        if (j == 9) { i += 1; j = 0; }
        if (i == 9) return true;

        // If pre-filled, move on
        if (board[i][j] != '.') {
            return solve(i, j + 1, board);
        }

        // Empty cell: try digits 1..9
        for (int num = 1; num <= 9; num++) {
            if (rowCheck(i, j, num, board) &&
                colCheck(i, j, num, board) &&
                gridCheck(i, j, num, board)) {
                board[i][j] = (char) (num + '0');
                if (solve(i, j + 1, board)) return true;
                board[i][j] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        solve(0, 0, board);
    }
}
