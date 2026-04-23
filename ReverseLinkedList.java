/*
 * Problem: Reverse Linked List
 * Difficulty: Easy
 * Source: LeetCode #206 (NeetCode 150 / LeetCode Top Interview 150)
 *
 * Problem Statement:
 *   Given the head of a singly linked list, reverse the list and return the
 *   reversed list's new head.
 *
 * Approach:
 *   Iterative three-pointer reversal. Keep `prev` (initially null) and walk
 *   `curr` through the list. For each node, save `curr.next` in `nextTemp`,
 *   point `curr.next` back to `prev`, then advance `prev = curr` and
 *   `curr = nextTemp`. When `curr` is null, `prev` is the new head.
 *
 * Time Complexity:  O(n)  — each node visited once.
 * Space Complexity: O(1)  — constant extra pointers, done in place.
 */

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // --- helpers for the sample runs ---
    private static ListNode buildList(int[] vals) {
        ListNode dummy = new ListNode(0), tail = dummy;
        for (int v : vals) { tail.next = new ListNode(v); tail = tail.next; }
        return dummy.next;
    }

    private static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(", ");
            head = head.next;
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        // Sample 1
        ListNode l1 = buildList(new int[] { 1, 2, 3, 4, 5 });
        System.out.println("Input:  " + toString(l1));
        System.out.println("Output: " + toString(reverseList(l1))); // [5, 4, 3, 2, 1]

        // Sample 2: single node
        ListNode l2 = buildList(new int[] { 42 });
        System.out.println("Input:  " + toString(l2));
        System.out.println("Output: " + toString(reverseList(l2))); // [42]

        // Sample 3: empty list
        System.out.println("Input:  []");
        System.out.println("Output: " + toString(reverseList(null))); // []
    }
}
