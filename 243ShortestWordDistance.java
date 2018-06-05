/**
 * 243 Shortest Word Distance
 * Related Topics: Array
 */

 /**
  * My accepted version
  * Time Complexity: O(n^2)
  * Space Complexity: O(n)
  *
  * Error Prone:
  * 1. ArrayList<Integer> name = new ArrayList<Integer>();
  * 2. Integer.MAX_VALUE
  */
  
  class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        ArrayList<Integer> w1 = new ArrayList<Integer>();
        ArrayList<Integer> w2 = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                w1.add(new Integer(i));
            } else if (words[i].equals(word2)) {
                w2.add(new Integer(i));
            }
        }
        ArrayList<Integer> dis = new ArrayList<Integer>();
        for (Integer wd1: w1) {
            for (Integer wd2: w2) {
                dis.add(Math.abs(wd1-wd2));
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer d: dis) {
            if (d < min) {
                min = d;
            }
        }
        return min;
    }
}

 /**
  * Improved version
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  * Basic Idea: One pass, keeping the most recent index
  *
  * Error Prone:
  * 1. ArrayList<Integer> name = new ArrayList<Integer>();
  * 2. Integer.MAX_VALUE
  */

  class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int w1 = -1, w2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                w1 = i;
            } else if (words[i].equals(word2)) {
                w2 = i;
            }
            if (w1 != -1 && w2 != -1) {
                min = Math.min(min, Math.abs(w1-w2));
            }
        }
        return min;
    }
}

 /**
  * Improved version 2
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  * Basic Idea: moving the smaller index forward
  *
  * Error Prone:
  * 1. Math.min(a, b);
  * 2. Math.abs(a, b);
  */
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int w1 = next_index(words, word1, -1);
        int w2 = next_index(words, word2, -1);
        int min = Integer.MAX_VALUE;
        while (w1 < words.length || w2 < words.length) {
            min = Math.min(min, Math.abs(w1-w2));
            if (w1 < w2) {
                w1 = next_index(words, word1, w1);
            } else {
                w2 = next_index(words, word2, w2);
            }
        }
        return min;
    }
    
    private int next_index(String[] words, String word, int index) {
        for (int i = index+1; i < words.length; i++) {
            if (words[i].equals(word)) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}