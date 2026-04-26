package SlidingWindow;

/*
 * Problem: Longest Repeating Character Replacement
 * Difficulty: Medium
 * Source: LeetCode #424 / NeetCode 150
 *
 * You are given a string s and an integer k. You can choose any character of the
 * string and change it to any other uppercase English character. You can perform
 * this operation at most k times. Return the length of the longest substring
 * containing the same letter you can get after performing the above operations.
 *
 * Approach:
 *   Slide a window over s and track the count of each letter inside the window
 *   along with the highest single-letter count seen so far in any window
 *   (maxFreq). The window is "valid" when (windowLength - maxFreq) <= k - that is,
 *   the number of replacements needed to make the window all the same letter
 *   fits in our budget. When invalid, advance left by one. The answer is the
 *   largest valid window length seen during the sweep.
 *
 * Time Complexity:  O(n) - each index is visited at most twice (once by right, once by left).
 * Space Complexity: O(1) - the count array has fixed size 26.
 */
public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0, maxFreq = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            int rIdx = s.charAt(right) - 'A';
            counts[rIdx]++;
            maxFreq = Math.max(maxFreq, counts[rIdx]);
            int windowLen = right - left + 1;
            if (windowLen - maxFreq > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        Object[][] cases = {
                {"ABAB", 2},
                {"AABABBA", 1},
                {"AAAA", 0},
                {"ABCDE", 1}
        };
        for (Object[] c : cases) {
            String s = (String) c[0];
            int k = (int) c[1];
            System.out.println("Input : s=\"" + s + "\", k=" + k);
            System.out.println("Output: " + characterReplacement(s, k));
            System.out.println();
        }
    }
}
