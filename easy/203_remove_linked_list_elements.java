
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) head = (head.val == val) ? head.next : head;
        ListNode currentNode = head;
        while(currentNode != null) {
            ListNode nextNode = currentNode.next;
            while(nextNode != null && nextNode.val == val) nextNode = nextNode.val == val ? nextNode.next : nextNode;
            currentNode.next = nextNode;
            currentNode = nextNode;
        }
        return head;
    }
}
