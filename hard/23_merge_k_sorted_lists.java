/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int nullCount = 0;
        if(lists.length == 0) return null;
        boolean[] isNull = new boolean[lists.length];
        boolean isInit = false;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i = 0; i < lists.length; i++) nullCount = (lists[i] == null) ? nullCount + 1 : nullCount;
        if (nullCount == lists.length) return null;
        while(nullCount != lists.length){
            int minIndex = 0;
            int minValue = Integer.MAX_VALUE;
            for(int i = 0; i < lists.length; i++) {
                if (lists[i] != null && isNull[i] == false && minValue > lists[i].val) {
                    minValue = lists[i].val;
                    minIndex = i;
                }
            }
            if (isInit == false) {
                head.val = minValue;
                cur = head;
                isInit = true;
            } else {
                cur.next = new ListNode(minValue);
                cur = cur.next;
            }
            if (lists[minIndex].next != null) {
                lists[minIndex] = lists[minIndex].next;
            } else {
                isNull[minIndex] = true;
                nullCount ++;
            }
        }
        return head;
    }
}
