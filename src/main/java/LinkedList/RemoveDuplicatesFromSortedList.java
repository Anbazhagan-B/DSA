/*
 * Problem: Remove Duplicates from Sorted List
 * Difficulty: Easy
 * Source: LeetCode #83 | LeetCode Top Interview 150
 *
 * Problem Statement:
 * Given the head of a sorted linked list, delete all duplicates such that each element
 * appears only once. Return the linked list sorted as well. The list is guaranteed to
 * be sorted in ascending order.
 *
 * Approach:
 * Traverse with a single pointer. While the next node has the same value as the current
 * node, skip it by setting current.next = current.next.next. Advance the pointer only
 * when the next value is different. Single pass, in-place.
 *
 * Time Complexity:  O(n) — one pass through the list
 * Space Complexity: O(1) — in-place modification, no extra data structures
 */
public class RemoveDuplicatesFromSortedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next; // skip duplicate
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    private static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(",");
            head = head.next;
        }
        return sb.append("]").toString();
    }

    private static ListNode build(int... vals) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (int v : vals) { cur.next = new ListNode(v); cur = cur.next; }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example 1: [1,1,2] -> [1,2]
        System.out.println("Example 1 [1,1,2]: " + listToString(deleteDuplicates(build(1, 1, 2)))); // [1,2]

        // Example 2: [1,1,2,3,3] -> [1,2,3]
        System.out.println("Example 2 [1,1,2,3,3]: " + listToString(deleteDuplicates(build(1, 1, 2, 3, 3)))); // [1,2,3]

        // Example 3: empty list -> []
        System.out.println("Example 3 []: " + listToString(deleteDuplicates(null))); // []

        // Example 4: [1,1,1] -> [1]
        System.out.println("Example 4 [1,1,1]: " + listToString(deleteDuplicates(build(1, 1, 1)))); // [1]
    }
}
