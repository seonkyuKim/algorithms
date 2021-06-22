package interleavingString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterleavingStringTest {

    InterleavingString interleavingString = new InterleavingString();

    /**
     * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * Output: true
     */
    @Test
    void defaultTest1() {
        assertTrue(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    /**
     * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * Output: false
     */
    @Test
    void defaultTest2() {
        assertFalse(interleavingString.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    /**
     * Input: s1 = "", s2 = "", s3 = ""
     * Output: true
     */
    @Test
    void defaultTest3() {
        assertTrue(interleavingString.isInterleave("", "", ""));
    }

    /**
     * Input: s1 = "ab", s2 = "b", s3 = "abb"
     * Output: true
     */
    @Test
    void test1() {
        assertTrue(interleavingString.isInterleave("ab", "b", "abb"));
    }

    /**
     * Input: s1 = "ab", s2 = "c", s3 = "abb"
     * Output: true
     */
    @Test
    void test2() {
        assertFalse(interleavingString.isInterleave("ab", "c", "abb"));
    }

    /**
     * Input: s1 = "aab", s2 = "bdd", s3 = "aabddb"
     * Output: true
     */
    @Test
    void test3() {
        assertTrue(interleavingString.isInterleave("aab", "bdd", "aabddb"));
    }

    /**
     * Input: s1 = "a", s2 = "b", s3 = "a"
     * Output: true
     */
    @Test
    void test4() {
        assertFalse(interleavingString.isInterleave("a", "b", "a"));
    }

    /**
     * "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa"
     * "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab"
     * "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"
     */

}
