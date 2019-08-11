/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // make l1 < l2
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1 == null && l2 == null) return null;
        if (l1.val > l2.val) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        ListNode head = l1;
        System.out.println(l1.val);
        while(true) {
            if (l1.next != null && l1.next.val > l2.val) {
                System.out.println(l2.val);

                ListNode tmp = new ListNode(l2.val);
                tmp.next = l1.next;
                l1.next = tmp;
                l1 = l1.next;

                if (l2.next != null) l2 = l2.next;
                else break;
            } else if (l1.next == null && l2 != null) {
                l1.next = l2;
                System.out.print(l2.val * 100);

                if (l2.next != null) {
                    System.out.print(" l2 has next :");
                    System.out.println(l2.val);
                    l2 = l2.next;
                } else {
                    break;
                }
            } else {
                System.out.println(l1.val * 10);

                if (l1.next != null) l1 = l1.next;
                else break;
            }
        }
        return head;
    }
}
