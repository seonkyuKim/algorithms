package maxAreaOfIsland;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxAreaOfIslandTest {

    MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();

    /**
     * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * Output: 6
     * Explanation: The answer is not 11, because the island must be connected 4-directionally.
     */
    @Test
    void defaultTest1() {
        int[][] input = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        int expectedOutput = 6;

        assertEquals(expectedOutput, maxAreaOfIsland.maxAreaOfIsland(input));
    }

    /**
     * Input: grid = [[0,0,0,0,0,0,0,0]]
     * Output: 0
     */
    @Test
    void defaultTest2() {
        int[][] input = {
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        int expectedOutput = 0;

        assertEquals(expectedOutput, maxAreaOfIsland.maxAreaOfIsland(input));
    }

    @Test
    void customTest1() {
        int[][] input = {
                {1, 0, 0},
                {0, 0, 0}
        };

        int expectedOutput = 1;

        assertEquals(expectedOutput, maxAreaOfIsland.maxAreaOfIsland(input));
    }

    @Test
    void customTest2() {
        int[][] input = {
                {1, 1, 0},
                {0, 0, 0}
        };

        int expectedOutput = 2;

        assertEquals(expectedOutput, maxAreaOfIsland.maxAreaOfIsland(input));
    }

    @Test
    void customTest3() {
        int[][] input = {
                {1, 1, 0},
                {0, 1, 0}
        };

        int expectedOutput = 3;

        assertEquals(expectedOutput, maxAreaOfIsland.maxAreaOfIsland(input));
    }

    @Test
    void booleanDefault() {
        boolean[] b = new boolean[4];

        for (boolean value : b) {
            assertFalse(value);
        }
    }

}
