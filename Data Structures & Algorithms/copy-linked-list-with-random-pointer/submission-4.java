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
        while(curr != null){
          Node newNode  = new Node(curr.val);
          Node temp = curr.next;
          curr.next = newNode;
          newNode.next = temp;
          curr = curr.next.next;                              
        }

        curr = head;
        while(curr != null){
            Node insertedCopiedNode =  curr.next;
            if(curr.random != null){
                insertedCopiedNode.random = curr.random.next;
            }            
            curr = curr.next.next; 
        }

        curr = head;
        Node newListHead = null;
        Node newListCurr = null;
        Node newListprev = null;
        while(curr != null){
             if(newListHead == null){
                newListHead = curr.next;
             }
             newListCurr = curr.next;
             if(newListprev != null){
                newListprev.next = newListCurr;
             }
             newListprev = newListCurr;
             curr.next = curr.next.next;
             curr = curr.next;   
        }
        return newListHead;        
    }
}
