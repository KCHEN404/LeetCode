/**
 * 266 Palindrome Permutation
 * Related Topics: Hash
 */

 /**
  * My accepted version
  * Error Prone:
  * 1. hashtable does not accept primitive type
  * 2. hashtable constructor: Hashtable<Type, Type> ht  =  new Hashtable<Type, Type>();
  * 3. char c to Character ch: Character ch = new Character(c);
  * 4. hashtable ht.get(key): return value or null 
  * 5. hashtable update value: ht.put(key, new value);
  * 6. hashtable values(): return collection of values
  * 7. iterate over: for (Type name: collection)
  */

import java.util.Hashtable;

class Solution {
    public boolean canPermutePalindrome(String s) {
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character ch = new Character(c);
            if (ht.get(ch) == null) {
                ht.put(ch, 1);
            } else {
                ht.put(ch, ht.get(ch) + 1);
            }
        }
        int count = 0;
        for (int val: ht.values()) {
            if (val%2 != 0) {
                count++;
            }
        }
        if (count > 1) {
            return false;
        } else {
            return true;
        }
    }
}