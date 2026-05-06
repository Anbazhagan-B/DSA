package Searching;

/*
 * Problem: First Bad Version
 * Difficulty: Easy
 * Source: LeetCode #278 (LC Top Interview 150)
 *
 * You are a product manager and currently leading a team to develop a new product.
 * Since each version is developed based on the previous version, all the versions
 * after a bad version are also bad. Given an API isBadVersion(version) which returns
 * whether a version is bad, find the first bad version (1..n) using as few API calls
 * as possible.
 *
 * Approach:
 * Classic binary search on the integer range [1, n]. Maintain a search window
 * [lo, hi] and while lo < hi, probe mid = lo + (hi - lo) / 2. If isBadVersion(mid),
 * the first bad version is at mid or earlier, so hi = mid; otherwise lo = mid + 1.
 * Using mid = lo + (hi - lo) / 2 avoids 32-bit overflow when n is near Integer.MAX_VALUE.
 *
 * Time:  O(log n) API calls.
 * Space: O(1).
 */
public class FirstBadVersion {

    // Simulated bad-version oracle for the demo (first bad version in this stub is `firstBad`).
    private static int firstBad;

    private static boolean isBadVersion(int version) {
        return version >= firstBad;
    }

    public static int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        firstBad = 4;
        System.out.println("n=5, firstBad=4 -> " + firstBadVersion(5)); // 4

        firstBad = 1;
        System.out.println("n=1, firstBad=1 -> " + firstBadVersion(1)); // 1

        firstBad = 1702766719;
        System.out.println("n=2126753390 -> " + firstBadVersion(2126753390)); // 1702766719
    }
}
