package linkedlist;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LC_1669_MergeInBetweenLinkedLists {

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0);
        dummy.next = list1;

        ListNode nodeBeforeA = list1;
        ListNode curr = list1;

        for (int i = 0; i < a; i++) {
            nodeBeforeA = curr;
            curr = curr.next;
        }

        nodeBeforeA.next = list2;

        while (list2.next != null) {
            list2 = list2.next;
        }

        for (int i = a; i <= b; i++) {
            curr = curr.next;
        }

        list2.next = curr;

        return dummy.next;
    }

    // Helper method to build linked list from array
    public static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int val : values) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummy.next;
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1: Regular Case
        ListNode list1 = buildList(new int[]{0, 1, 2, 3, 4, 5});
        ListNode list2 = buildList(new int[]{1000000, 1000001, 1000002});
        System.out.print("Original list1: ");
        printList(list1);
        System.out.print("List2 to merge: ");
        printList(list2);
        ListNode result = mergeInBetween(list1, 3, 4, list2);
        System.out.print("After mergeInBetween(3, 4): ");
        printList(result);

        // Test Case 2: Edge Case - Replace single node
        list1 = buildList(new int[]{1, 2, 3});
        list2 = buildList(new int[]{9});
        result = mergeInBetween(list1, 1, 1, list2);
        System.out.print("After mergeInBetween(1, 1): ");
        printList(result);
    }
}
