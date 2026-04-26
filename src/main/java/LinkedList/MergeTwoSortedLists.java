package LinkedList;

/*
 * Problem: Merge Two Sorted Lists
 * Difficulty: Easy
 * Source: LeetCode #21 / NeetCode 150
 *
 * You are given the heads of two sorted linked lists list1 and list2. Merge the two
 * lists into one sorted list by splicing together the nodes of the original lists,
 * and return the head of the merged list.
 *
 * Approach:
 *   Use a dummy head node and a tail pointer. Repeatedly attach the smaller of the
 *   two current nodes to the tail and advance that list. After the loop, attach the
 *   remainder of the non-empty list. The original nodes are reused; no allocations
 *   beyond the dummy header are required.
 *
 * Time Complexity:  O(n + m) - each node from both lists is visited once.
 * Space Complexity: O(1) - in-place pointer rewiring; no auxiliary structures.
 */
public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    private static ListNode build(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int v : values) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    private static String render(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        ListNode node = head;
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) sb.append(", ");
            node = node.next;
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        int[][][] cases = {
                { {1, 2, 4}, {1, 3, 4} },
                { {}, {} },
                { {}, {0} },
                { {-5, 0, 7}, {-3, 4, 9} }
        };
        for (int[][] pair : cases) {
            ListNode merged = mergeTwoLists(build(pair[0]), build(pair[1]));
            System.out.println("Input list1: " + render(build(pair[0])));
            System.out.println("Input list2: " + render(build(pair[1])));
            System.out.println("Merged     : " + render(merged));
            System.out.println();
        }
    }
}
