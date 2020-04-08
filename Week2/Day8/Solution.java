/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode middleNode(ListNode head) {        
        ListNode slower = head;
        ListNode faster = head;
        
        while (faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
        }
        
        return slower;
    }
}