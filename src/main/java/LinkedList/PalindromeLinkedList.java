/*
 * Problem: Palindrome Linked List
 * Difficulty: Easy
 * Source: LeetCode #234 / NeetCode 150
 *
 * Given the head of a singly linked list, return true if it is a palindrome —
 * i.e., the values read the same forwards and backwards.
 *
 * Approach:
 *   1. Find the middle of the list with the slow/fast two-pointer technique.
 *   2. Reverse the second half of the list in place.
 *   3. Walk the first half (from head) and the reversed second half together,
 *      comparing values. If any pair differs the list isn't a palindrome.
 *   This runs in linear time without using an auxiliary array.
 *
 * Time:  O(n) — three linear passes (find middle, reverse, compare).
 * Space: O(1) extra — only pointer rewiring; no new nodes are allocated.
 */
package LinkedList;

public class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { this.val = v; }
        ListNode(int v, ListNode n) { this.val = v; this.next = n; }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find middle (slow ends at start of second half for odd lengths).
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half.
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        // 3. Compare halves.
        ListNode left = head, right = prev;
        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private static ListNode build(int... vals) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int v : vals) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[][] cases = {
                {1, 2, 2, 1},
                {1, 2},
                {1, 2, 3, 2, 1},
                {1}
        };
        for (int[] c : cases) {
            ListNode h = build(c);
            System.out.println(java.util.Arrays.toString(c) + " -> " + isPalindrome(h));
        }
    }
}
