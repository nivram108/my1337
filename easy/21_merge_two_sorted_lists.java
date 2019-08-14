//TAG ListNode
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // make l1 < l2
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1 == null && l2 == null) return null;
        // make l1 be the smaller one
        if (l1.val > l2.val) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        ListNode head = l1;
        while(true) {
            if (l2 == null) { // all remaining nodes will link to l1
                break;
            } else if(l1.next == null) { // link all remaining nodes to l1
                l1.next = l2;
                break;
            } else if(l1.next.val > l2.val) { // insert l2 node to l1 and update current position
                ListNode tmp = new ListNode(l1.next.val);
                tmp.next = l1.next.next;
                l1.next = new ListNode(l2.val);
                l1.next.next = tmp;
                l2 = l2.next;
                l1 = l1.next;
            } else {
                l1 = l1.next;
            }
        }
        return head;
    }
}
