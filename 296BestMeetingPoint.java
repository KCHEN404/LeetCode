/**
 * 296. Best Meeting Point
 * Related Topics: Tree
 */

 /**
  * My accepted version
  *  
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *
  */

class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dis = 0;
        int[] home = new int[m*n];
        for (int dim = 0; dim < 2; dim++) {
            int a = 0, b = 0;
            if (dim == 0) {
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        if (grid[y][x] == 1) {
                            home[b++] = x;
                        }
                    }
                }
            } else {
                for (int y = 0; y < m; y++) {
                    for (int d: grid[y]) {
                        if (d == 1) {
                            home[b++] = y;
                        }
                    }
                }
            }
            b--;
            while (a < b) {
                dis += home[b--] - home[a++];
            }
        }
        return dis;
    }
}