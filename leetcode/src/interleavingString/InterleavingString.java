/*
 * https://leetcode.com/problems/interleaving-string/
 *
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 *
 *   s = s1 + s2 + ... + sn
 *   t = t1 + t2 + ... + tm
 *   |n - m| <= 1
 *   The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 *
 * Note: a + b is the concatenation of strings a and b.
 */
package interleavingString;

public class InterleavingString {
    // TODO: substring 대신 index 를 넘겨주는 방식으로 변경
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        if (s3.length() == 0) {
            return true;
        }

        if (s1.length() > 0 && s3.charAt(0) == s1.charAt(0)) {
            boolean firstResult = isInterleave(s1.substring(1), s2, s3.substring(1));
            if (firstResult) {
                return true;
            }
        }
        if (s2.length() > 0 && s3.charAt(0) == s2.charAt(0)) {
            return isInterleave(s1, s2.substring(1), s3.substring(1));
        }

        return false;
    }
}
