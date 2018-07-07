/**
 * 252. Meeting Rooms
 * Related Topics: Sort
 */

 /**
  * Accepted version
  *  
  * Time Complexity: O(nlogn)
  * Space Complexity: O(1)
  *
  * Basic idea: custom comparator
  *
  * Error Prone:
  * 1. Short way of creating Comparator:
  * Comparator<Class> name = new Comparator<Class>() {
  *     public int compare(Object obj1, Object obj2) {
  *         // comparing way
  *     }
  * };
  * 2. Custom sort based on Comparator:
  * Collections.sort(list, Comparator);
  *
  */

class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Comparator<Interval> itvl = new Comparator<Interval>() {
            public int compare(Interval v1, Interval v2) {
                return v1.start - v2.start;
            }
        };
        Arrays.sort(intervals, itvl);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }
        return true;
    }
}