/**
 * https://leetcode.com/problems/max-area-of-island/
 * <p>
 * You are given an m x n binary matrix grid.
 * An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */
package maxAreaOfIsland;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxArea = 0;

        for (int startM = 0; startM < m; startM++) {
            for (int startN = 0; startN < n; startN++) {
                if (visited[startM][startN]) continue;
                maxArea = Math.max(areaOfIslandStartFrom(grid, visited, startM, startN, 0), maxArea);
            }
        }

        return maxArea;
    }

    public int areaOfIslandStartFrom(int[][] grid, boolean[][] visited, int startM, int startN, int currentArea) {

        visited[startM][startN] = true;
        if (grid[startM][startN] == 0) return currentArea;

        int plusArea = 0;

        int m, n;

        // up
        m = startM - 1;
        n = startN;
        if (isInArea(grid, m, n) && !visited[m][n]) {
            plusArea = plusArea + areaOfIslandStartFrom(grid, visited, m, n, currentArea);
        }

        // right
        m = startM;
        n = startN + 1;
        if (isInArea(grid, m, n) && !visited[m][n]) {
            plusArea = plusArea + areaOfIslandStartFrom(grid, visited, m, n, currentArea);
        }

        // down
        m = startM + 1;
        n = startN;
        if (isInArea(grid, m, n) && !visited[m][n]) {
            plusArea = plusArea + areaOfIslandStartFrom(grid, visited, m, n, currentArea);
        }

        // left
        m = startM;
        n = startN - 1;
        if (isInArea(grid, m, n) && !visited[m][n]) {
            plusArea = plusArea + areaOfIslandStartFrom(grid, visited, m, n, currentArea);
        }

        return currentArea + plusArea + 1;
    }

    boolean isInArea(int[][] grid, int m, int n) {
        try {
            int value = grid[m][n];
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}
