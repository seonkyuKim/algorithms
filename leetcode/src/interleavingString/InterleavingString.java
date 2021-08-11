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
    // 105 / 106 test cases passed.
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return isInterleave(s1, 0, s2, 0, s3, 0);
    }

    private boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3) {
        if (i3 == s3.length()) {
            return true;
        }

        if (i1 < s1.length() && s3.charAt(i3) == s1.charAt(i1)) {
            boolean firstResult = isInterleave(s1, i1+1, s2, i2, s3, i3+1);
            if (firstResult) {
                return true;
            }
        }
        if (i2 < s2.length() && s3.charAt(i3) == s2.charAt(i2)) {
            return isInterleave(s1, i1, s2, i2+1, s3, i3+1);
        }
        return false;
    }


    public boolean isInterleaveWithLongTime2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return isInterleaveWithLongTime2(s1, 0, s2, 0, s3, 0);
    }

    private boolean isInterleaveWithLongTime2(String s1, int i1, String s2, int i2, String s3, int i3) {
        if (i3 == s3.length()) {
            return true;
        }

        if (i1 < s1.length() && s3.charAt(i3) == s1.charAt(i1)) {
            int count = countUntilNotSame(s1, i1, s3, i3);
            while(count > 0) {
                boolean result = isInterleaveWithLongTime2(s1, i1+count, s2, i2, s3, i3+count);
                if (result) {
                    return true;
                }
                count--;
            }
        }
        if (i2 < s2.length() && s3.charAt(i3) == s2.charAt(i2)) {
            int count = countUntilNotSame(s2, i2, s3, i3);
            while(count > 0) {
                boolean result = isInterleaveWithLongTime2(s1, i1, s2, i2+count, s3, i3+count);
                if (result) {
                    return true;
                }
                count--;
            }
        }
        return false;
    }

    // count 를 함수 안에서 다음 string 의 시작이 있을때까지만 세는 방식으로 바꿔보면 될듯 test 5인가 실패했던거 참고
    /**
     * @param s1 "aabcc"
     * @param i1 2
     * @param s2 "aadbbcbcbcac"
     * @param i2 6
     * @return 2
     */
    public int countUntilNotSame(String s1, int i1, String s2, int i2) {
        int count = 0;
        while (i1 < s1.length() && i2 < s2.length() && s1.charAt(i1) == s2.charAt(i2)) {
            count++;
            i1++;
            i2++;
        }

        return count;
    }

    // TODO: substring 대신 index 를 넘겨주는 방식으로 변경
    public boolean isInterleaveWithOldTime(String s1, String s2, String s3) {
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
