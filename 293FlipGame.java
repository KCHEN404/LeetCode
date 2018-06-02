/**
 * 293 Flip Game
 * Related Topics: String
 */

 /**
  * My accepted version
  * Time Complexity: O(n^2)
  * Space Complexity: O(n)
  *
  * Error Prone:
  * 1. substring(beginning index, ending index): ending index
  *    is the index of the first char that is not included
  * 2. List<Type> list_name = new ArrayList<>();
  * 3. list.add();
  * 4. StringBuilder name = new StringBuilder();
  * 5. stringbuilder.append();
  * 6. substring is O(n)
  */

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            String sub = s.substring(i, i+2);
            if (sub.equals("++")) {
                StringBuilder res = new StringBuilder();
                if (i > 0) {
                    res.append(s.substring(0, i));
                }
                res.append("--");
                if (i + 1 < s.length() - 1) {
                    res.append(s.substring(i + 2, s.length()));
                }
                result.add(res.toString());
            }
        }
        return result;
    }
}

/**
 * Improved version
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * Error Prone:
 * 1. charAt is a constant time operation
 * StringBuilder is faster than string "+"
 */

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                StringBuilder res = new StringBuilder();
                res.append(s.substring(0, i));
                res.append("--");
                res.append(s.substring(i + 2, s.length()));
                result.add(res.toString());
            }
        }
        return result;
        }
    }