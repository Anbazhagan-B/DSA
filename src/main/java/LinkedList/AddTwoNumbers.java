package LinkedList;

/*
 * Problem: Add Two Numbers
 * Difficulty: Medium
 * Source: LeetCode #2 (NeetCode 150)
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each node contains a
 * single digit. Add the two numbers and return the sum as a linked list, also
 * in reverse order. The lists do not contain leading zeros except the number 0
 * itself.
 *
 * Approach:
 * Walk both lists simultaneously with a running carry, simulating grade-school
 * addition. At each step sum the available digits plus the carry, push the
 * units digit onto the result list, and keep the tens digit as the next carry.
 * A dummy head node simplifies result construction. Continue while either list
 * has nodes or a carry remains.
 *
 * Time Complexity:  O(max(n, m)) - one pass over the longer list.
 * Space Complexity: O(max(n, m)) - the result list holds up to max+1 digits.
 */
public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }
        return dummy.next;
    }

    private static ListNode build(int... digits) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int d : digits) {
            tail.next = new ListNode(d);
            tail = tail.next;
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
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        // 342 + 465 = 807 -> stored reversed
        System.out.println("Input: [2,4,3] + [5,6,4] -> " + toStr(addTwoNumbers(build(2, 4, 3), build(5, 6, 4)))); // [7, 0, 8]
        // 0 + 0 = 0
        System.out.println("Input: [0] + [0] -> " + toStr(addTwoNumbers(build(0), build(0)))); // [0]
        // 9999999 + 9999 = 10009998
        System.out.println("Input: [9,9,9,9,9,9,9] + [9,9,9,9] -> "
                + toStr(addTwoNumbers(build(9, 9, 9, 9, 9, 9, 9), build(9, 9, 9, 9)))); // [8, 9, 9, 9, 0, 0, 0, 1]
    }
}
