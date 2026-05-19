/**
 * Problem: Middle of the Linked List
 * Difficulty: Easy
 * Source: LeetCode #876 / LeetCode 75
 *
 * Given the head of a singly linked list, return the middle node of the
 * linked list. If there are two middle nodes (even-length list), return
 * the second middle node.
 *
 * Approach:
 * - Use the slow and fast pointer technique (Floyd's two-pointer).
 * - Slow pointer advances one step; fast pointer advances two steps per iteration.
 * - When fast reaches the end (null or last node), slow is exactly at the middle.
 * - For even-length lists, this naturally returns the second middle.
 *
 * Time Complexity:  O(n) - single pass through the list
 * Space Complexity: O(1) - only two pointers used
 */
public class MiddleOfLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode buildList(int... vals) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : vals) { cur.next = new ListNode(v); cur = cur.next; }
        return dummy.next;
    }

    private static String listToString(ListNode node) {
        StringBuilder sb = new StringBuilder("[");
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) sb.append(",");
            node = node.next;
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        MiddleOfLinkedList sol = new MiddleOfLinkedList();

        // Odd length: middle is index 2 -> value 3, rest: [3,4,5]
        System.out.println(listToString(sol.middleNode(buildList(1, 2, 3, 4, 5)))); // [3,4,5]

        // Even length: second middle is index 3 -> value 4, rest: [4,5,6]
        System.out.println(listToString(sol.middleNode(buildList(1, 2, 3, 4, 5, 6)))); // [4,5,6]

        // Single element: middle is the only node
        System.out.println(listToString(sol.middleNode(buildList(42)))); // [42]

        // Two elements: second middle
        System.out.println(listToString(sol.middleNode(buildList(7, 9)))); // [9]
    }
}
