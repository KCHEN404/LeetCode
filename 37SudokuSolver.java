/**
 * 37. Sudoku Solver
 * Related Topics: backtracking
 */  

 /**
  * Accepted version
  *  
  * Time Complexity: don't know
  * Space Complexity: space for stack for recusion
  *
  */

  class Solution {
    public void solveSudoku(char[][] board) {
        if (board.length == 0) {
            return;
        }
        solve(board, 0); 
    }
    
    private boolean solve(char[][] board, int row) {
        for (int i = row; i < board.length; i++) { // do not start from 0, save time
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for(char k = '1'; k <= '9'; k++) { // loop using char
                        if (check(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board, i)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean check(char[][] board, int idx, int jdx, char k) {
        for (int i = 0; i < 9; i++) {
            if (board[i][jdx] == k) {
                return false;
            }
            if (board[idx][i] == k) {
                return false;
            }
            if (board[3*(idx/3) + i/3][3*(jdx/3) + i%3] == k) { // good way to check 3*3 grid
                return false;
            }
        }
        return true;
    } 
}