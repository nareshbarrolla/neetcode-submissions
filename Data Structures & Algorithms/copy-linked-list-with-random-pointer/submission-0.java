/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        Node curr = head;
        Node newListHead = null;
        Node prev = null;
        Map<Node, Node> trackingRandomRelationShipMap = new HashMap<>();
        while(curr != null){
          Node newNode  = new Node(curr.val);        
          // for tracking the new list head
          if(newListHead == null){
            newListHead = newNode;            
          }

          trackingRandomRelationShipMap.put(curr, newNode);
          
          // context current to prev next
          if(prev != null){
            prev.next = newNode;
          }
          // update the prev
          prev = newNode; 
          // move curr ahead. 
          curr = curr.next;         
        }

        Node temp = newListHead;
        curr = head;
        while(curr != null){
            if (curr.random != null) {
               temp.random = trackingRandomRelationShipMap.get(curr.random);
            }
            curr = curr.next;
            temp = temp.next;
        }
        return newListHead;
    }
}
