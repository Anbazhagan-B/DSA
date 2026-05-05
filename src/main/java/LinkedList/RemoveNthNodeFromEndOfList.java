/*
 * Problem: Remove Nth Node From End of List
 * Difficulty: Medium
 * Source: LeetCode #19 (NeetCode 150 - Linked List)
 *
 * Given the head of a linked list, remove the nth node from the end of the
 * list and return its head. The operation should be done in a single pass.
 *
 * Approach:
 *   Use the two-pointer (fast/slow) technique with a dummy node in front of
 *   head to gracefully handle the case where the head itself is removed.
 *   Advance `fast` n+1 steps so the gap between fast and slow is exactly n+1
 *   nodes; then move both pointers one step at a time until fast reaches null.
 *   At that point, slow.next is the node to remove. Splice it out by setting
 *   slow.next = slow.next.next.
 *
 * Time Complexity:  O(L) - single pass; L is list length.
 * Space Complexity: O(1) - a few pointers.
 */
package LinkedList;

public class RemoveNthNodeFromEndOfList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { this.val = v; }
        ListNode(int v, ListNode n) { this.val = v; this.next = n; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i <= n; i++) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    private static ListNode build(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static String toStr(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(", ");
            head = head.next;
        }
        return sb.append(']').toString();
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList solver = new RemoveNthNodeFromEndOfList();

        ListNode a = build(new int[]{1, 2, 3, 4, 5});
        System.out.println("Input : [1,2,3,4,5], n=2");
        System.out.println("Output: " + toStr(solver.removeNthFromEnd(a, 2))); // [1,2,3,5]

        ListNode b = build(new int[]{1});
        System.out.println("Input : [1], n=1");
        System.out.println("Output: " + toStr(solver.removeNthFromEnd(b, 1))); // []

        ListNode c = build(new int[]{1, 2});
        System.out.println("Input : [1,2], n=1");
        System.out.println("Output: " + toStr(solver.removeNthFromEnd(c, 1))); // [1]

        ListNode d = build(new int[]{10, 20, 30, 40});
        System.out.println("Input : [10,20,30,40], n=4");
        System.out.println("Output: " + toStr(solver.removeNthFromEnd(d, 4))); // [20,30,40]
    }
}
