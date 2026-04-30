package LinkedList;

/*
 * Problem: Linked List Cycle
 * Difficulty: Easy
 * Source: LeetCode #141 / NeetCode 150 / LC Top Interview 150
 *
 * Given the head of a singly linked list, return true if there is a cycle in
 * the list. A cycle exists if some node can be revisited by continuously
 * following the next pointer. The list size can be up to 10^4 nodes.
 *
 * Approach (Floyd's Tortoise and Hare):
 *   Use two pointers, slow advancing one node at a time and fast advancing
 *   two. If a cycle exists they will eventually meet inside the loop; if no
 *   cycle exists, fast hits null. Constant extra memory, no node mutation.
 *
 * Time Complexity:  O(n) — fast pointer traverses at most ~2n nodes.
 * Space Complexity: O(1) — only two pointers regardless of list size.
 */
public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { this.val = v; }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    private static ListNode build(int[] vals, int cycleIdx) {
        if (vals.length == 0) return null;
        ListNode head = new ListNode(vals[0]);
        ListNode curr = head;
        ListNode cycleNode = (cycleIdx == 0) ? head : null;
        for (int i = 1; i < vals.length; i++) {
            curr.next = new ListNode(vals[i]);
            curr = curr.next;
            if (i == cycleIdx) cycleNode = curr;
        }
        if (cycleNode != null) curr.next = cycleNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = build(new int[]{3, 2, 0, -4}, 1);
        System.out.println("Input:  [3,2,0,-4] cycle->index 1");
        System.out.println("Output: " + hasCycle(l1)); // true

        ListNode l2 = build(new int[]{1, 2}, 0);
        System.out.println("Input:  [1,2] cycle->index 0");
        System.out.println("Output: " + hasCycle(l2)); // true

        ListNode l3 = build(new int[]{1}, -1);
        System.out.println("Input:  [1] no cycle");
        System.out.println("Output: " + hasCycle(l3)); // false

        System.out.println("Input:  [] (empty)");
        System.out.println("Output: " + hasCycle(null)); // false
    }
}
