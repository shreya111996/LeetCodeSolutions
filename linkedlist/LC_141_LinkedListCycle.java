package linkedlist;

public class LC_141_LinkedListCycle {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * TC: O(n) - where n is the number of nodes in the linked list
     * SC: O(1) - no extra space used
     */

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test Case 1: No cycle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        System.out.println(hasCycle(head1)); // false

        // Test Case 2: Cycle exists (tail connects to second node)
        ListNode head2 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head2.next = node2;
        node2.next = node3;
        node3.next = node2; // creates a cycle
        System.out.println(hasCycle(head2)); // true

        // Test Case 3: Single node with no cycle
        ListNode head3 = new ListNode(1);
        System.out.println(hasCycle(head3)); // false

        // Test Case 4: Single node pointing to itself
        ListNode head4 = new ListNode(1);
        head4.next = head4;
        System.out.println(hasCycle(head4)); // true
    }
}
