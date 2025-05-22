package linkedlist;

public class LC_203_RemoveLinkedListElements {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /* 
     * TC: O(n)
     * SC: O(1)
     */
    
    public static ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return head;
        }

        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;

        ListNode prev = dummyhead;
        ListNode curr = dummyhead.next;

        while (curr != null) {
            if (curr.val == val) {
                curr = curr.next;
                prev.next = curr;
            } else {
                prev = curr;
                curr = prev.next;
            }
        }

        return dummyhead.next;
    }

    // Utility method to build a linked list from array
    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Utility method to print the linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1: Remove existing value
        ListNode head1 = buildList(new int[]{1, 2, 6, 3, 4, 5, 6});
        printList(removeElements(head1, 6)); // Expected: 1 -> 2 -> 3 -> 4 -> 5

        // Test Case 2: No value to remove
        ListNode head2 = buildList(new int[]{1, 2, 3});
        printList(removeElements(head2, 4)); // Expected: 1 -> 2 -> 3

        // Test Case 3: All values to remove
        ListNode head3 = buildList(new int[]{7, 7, 7});
        printList(removeElements(head3, 7)); // Expected: (empty)

        // Test Case 4: Empty list
        ListNode head4 = null;
        printList(removeElements(head4, 1)); // Expected: (empty)

        // Test Case 5: Head node to remove
        ListNode head5 = buildList(new int[]{1, 2, 3});
        printList(removeElements(head5, 1)); // Expected: 2 -> 3
    }
}
