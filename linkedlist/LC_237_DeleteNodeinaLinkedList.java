package linkedlist;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class LC_237_DeleteNodeinaLinkedList {

    /*
     * TC: O(1) - since we are not traversing the list, just modifying pointers
     * SC: O(1) - no extra space used
     */

    // Deletes the given node (not the tail) from the linked list
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /* ---- My Solution ----- 
     * public void deleteNode(ListNode node) {

        ListNode prev = null;
        while (node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }

        prev.next = null;

    }
     */

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Helper method to find a node by value (first occurrence)
    public static ListNode findNode(ListNode head, int value) {
        ListNode curr = head;
        while (curr != null && curr.val != value) {
            curr = curr.next;
        }
        return curr;
    }

    public static void main(String[] args) {

        // Test Case 1: Delete node 5 in 4 -> 5 -> 1 -> 9
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(9);

        System.out.print("Original list: ");
        printList(head1);

        ListNode nodeToDelete1 = findNode(head1, 5);
        deleteNode(nodeToDelete1);

        System.out.print("After deleting node 5: ");
        printList(head1);

        // Test Case 2 (Edge case): Delete node 1 in 1 -> 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.print("Original list: ");
        printList(head2);

        ListNode nodeToDelete2 = findNode(head2, 1);
        deleteNode(nodeToDelete2);

        System.out.print("After deleting node 1: ");
        printList(head2);
    }
}
