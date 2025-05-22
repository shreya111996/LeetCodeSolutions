package linkedlist;

public class LC_24_SwapNodesinPairs {

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

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode prev = dummyhead;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;
            prev.next = second;
            first.next = second.next;
            second.next = first;
            prev = first;
        }

        return dummyhead.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1: Even number of nodes
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.print("Original: ");
        printList(head1);
        ListNode result1 = swapPairs(head1);
        System.out.print("Swapped : ");
        printList(result1);

        // Test Case 2: Odd number of nodes
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.print("Original: ");
        printList(head2);
        ListNode result2 = swapPairs(head2);
        System.out.print("Swapped : ");
        printList(result2);

        // Test Case 3: Single node
        ListNode head3 = new ListNode(1);
        System.out.print("Original: ");
        printList(head3);
        ListNode result3 = swapPairs(head3);
        System.out.print("Swapped : ");
        printList(result3);

        // Test Case 4: Empty list
        ListNode head4 = null;
        System.out.print("Original: ");
        printList(head4);
        ListNode result4 = swapPairs(head4);
        System.out.print("Swapped : ");
        printList(result4);
    }
}
