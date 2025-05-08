package linkedlist;

public class LC_142_LinkedListCycleII {

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

     
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // Test Case 1: No cycle
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        System.out.println(detectCycle(head1)); // null

        // Test Case 2: Cycle starts at node with value 2
        ListNode head2 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head2.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // creates cycle
        System.out.println(detectCycle(head2).val); // 2

        // Test Case 3: Single node, no cycle
        ListNode head3 = new ListNode(1);
        System.out.println(detectCycle(head3)); // null

        // Test Case 4: Single node pointing to itself
        ListNode head4 = new ListNode(1);
        head4.next = head4;
        System.out.println(detectCycle(head4).val); // 1
    }
}
