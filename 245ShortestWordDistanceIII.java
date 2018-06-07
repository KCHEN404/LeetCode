/**
 * 245. Shortest Word Distance III
 * Related Topics: Array, Two Pointers
 */

 /**
  * My accepted version
  *
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *
  */

class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int ind_1 = next(words, word1, -1, -1);
        int ind_2 = next(words, word2, -1, ind_1);
        int min = Math.abs(ind_1-ind_2);
        while (ind_1 < words.length || ind_2 < words.length) {
            if (ind_1 < ind_2) {
                ind_1 = next(words, word1, ind_1, ind_2);
            } else {
                ind_2 = next(words, word2, ind_2, ind_1);
            }
            if (ind_1 != -1 && ind_2 != -1 && ind_1 < words.length && ind_2 < words.length) {
                min = Math.min(min, Math.abs(ind_1 - ind_2));
            }
        }
        return min;
    }
    
    private int next(String[] words, String word, int index, int other) {
        for (int i = index + 1; i < words.length; i++) {
            if (words[i].equals(word)) {
                if (other != i) {
                    return i;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}