/**
 * 79. Word Search
 * Related Topics: backtracking
 */  

 /**
  * Accepted Bottom up version
  *  
  * Time Complexity: at least O(4*n)
  * Space Complexity: O(board size)
  *
  * Error Prone:
  * 1. have to set the used spot back to free spot if current sequence is not correct
  */

class Solution {
    static boolean[][] used;
    
    public boolean exist(char[][] board, String word) {
        used = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(search(board, i, j, word, 0)) { // start from 0, not 1
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, int i, int j, String word, int index) {
        // check ending case
        if (index == word.length()) {
            return true;
        }

        // check if current spot is correct
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(index) != board[i][j] || used[i][j]) {
            return false;
        }

        // continue the sequence
        used[i][j] = true;
        if (search(board, i - 1, j, word, index + 1) || search(board, i + 1, j, word, index + 1) || search(board, i, j - 1, word, index + 1) || search(board, i, j + 1, word, index + 1)) {
            return true;
        }

        // not the correct sequence
        used[i][j] = false;
        return false;
        
    }
}