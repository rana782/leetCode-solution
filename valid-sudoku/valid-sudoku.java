// LeetCode: Valid Sudoku (valid-sudoku)
// Submission ID: 1753109959
// Language: java
// Timestamp (UTC): 2025-08-30T05:28:53Z

class Solution {
    public boolean isValidSudoku(char[][] board) {
        return check(0, 0, board); // recursive traversal over the 9x9 grid [web:21][web:24]
    }

    // Recursively walk the board row-major; stop early if any constraint fails.
    private boolean check(int r, int c, char[][] board) {
        if (c == 9) { r++; c = 0; }            // move to next row [web:24]
        if (r == 9) return true;               // scanned all cells, no violations found [web:24]
        char ch = board[r][c];
        if (ch != '.') {
            if (!rowOk(r, ch, c, board)) return false;   // validate row with this cell [web:19][web:24]
            if (!colOk(c, ch, r, board)) return false;   // validate column with this cell [web:19][web:24]
            if (!boxOk(r, c, ch, board)) return false;   // validate 3x3 box with this cell [web:19][web:24]
        }
        return check(r, c + 1, board);         // advance to next cell [web:24]
    }

    // Row validity: ch must be unique in row r excluding column cSelf.
    private boolean rowOk(int r, char ch, int cSelf, char[][] board) {
        for (int c = 0; c < 9; c++) {
            if (c == cSelf) continue;
            char x = board[r][c];
            if (x == ch) return false;         // duplicate in the row [web:19][web:24]
        }
        return true;
    }

    // Column validity: ch must be unique in column c excluding row rSelf.
    private boolean colOk(int c, char ch, int rSelf, char[][] board) {
        for (int r = 0; r < 9; r++) {
            if (r == rSelf) continue;
            char x = board[r][c];
            if (x == ch) return false;         // duplicate in the column [web:19][web:24]
        }
        return true;
    }

    // Box validity: ch must be unique in its 3x3 sub-box.
    private boolean boxOk(int r, int c, char ch, char[][] board) {
        int sr = (r / 3) * 3, sc = (c / 3) * 3; // top-left of the 3x3 sub-box [web:24]
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (i == r && j == c) continue;
                char x = board[i][j];
                if (x == ch) return false;     // duplicate in the 3x3 box [web:19][web:24]
            }
        }
        return true;
    }
}
