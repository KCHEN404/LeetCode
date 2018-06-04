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
