/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 class Solution {
     int counter;
     public ListNode reverseList(ListNode head) {
         if(head == null) return head;
         counter = -1;
         ListNode cur = head;
         recursive(head, cur);
         while((counter--) > 0) head = head.next;
         return head;
     }

     ListNode recursive(ListNode head, ListNode cur) {
         int v = cur.val;
         counter ++;
         if(cur.next == null) {
             head = cur;
             return cur;
         } else {
             cur = cur.next;
             head = head.next;
             ListNode n = recursive(head, cur);
             n.next = new ListNode(v);
             return n.next;
         }
     }
 }
