/**
 * 281 Zigzag Iterator
 * Related Topics: Design
 */

 /**
  * Accepted version
  * Basic Idea: 
  *
  * Time Complexity: O(n)
  * Space Complexity: O(k)?
  *
  * Error Prone:
  * 1. 
  */

public class ZigzagIterator {

    LinkedList<Iterator> list = new LinkedList<Iterator>();
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {

        if (!v1.isEmpty()) {
            list.add(v1.iterator());
        }
        if (!v2.isEmpty()) {
            list.add(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> iter = list.remove();
        int res = iter.next();
        if (iter.hasNext()) {
            list.add(iter);
        }
        return res;
    }

    public boolean hasNext() {
        return (!list.isEmpty());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */