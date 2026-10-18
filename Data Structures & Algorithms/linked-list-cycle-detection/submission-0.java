/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
      Set<ListNode> visitedNode = new HashSet<>();
      boolean cycleFound = false;
      while(head != null && !cycleFound){
        if(visitedNode.contains(head.next)){
            return true;
        }
        visitedNode.add(head);
        head = head.next;        
      }
      return false;
    }
}
