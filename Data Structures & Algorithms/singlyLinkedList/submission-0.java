
class LinkedList {   

    private Node head = null; 
    private Node current = null; 

    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;                
        }
    }

    public LinkedList() {
        head = null;
    }

    public int get(int index) {
        if(head == null){
            return -1;
        }
        Node currentHead = head; 
        int currentIndex = 0;
        while(currentHead != null){           
             if(currentIndex == index){
                return currentHead.data;
             }
             currentHead = currentHead.next; 
             currentIndex++;
        }
        return -1;        
    }

    public void insertHead(int val) {
        Node currentNode = new Node(val);   
        if(head != null){
            currentNode.next = head;
            head = currentNode;
        }    
        if(head == null){
            head = currentNode;  
            current =  currentNode;         
        }
    }

    public void insertTail(int val) {
        Node currentNode = new Node(val);
        if(current == null){
            head = currentNode;
            current = currentNode;
            return;
        }
        if(current != null){
            current.next = currentNode;
            current = currentNode;
        }
    }

    public boolean remove(int index) {
        if(head == null || index < 0){
            return false;
        }
        if(index == 0){
            head = head.next;
            if (head == null) {
                current = null;
            }
            return true;
        }
        Node currentHead = head; 
        Node prev = head;
        int currentIndex = 0;
        while(currentHead != null){            
            if(currentIndex == index){
                prev.next = currentHead.next;
                if(currentHead == current){
                    current = prev;
                }
                return true;
            }
            prev = currentHead;
            currentHead = currentHead.next;
            currentIndex++;
        }
        return false;        
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> listValues = new ArrayList();
        Node currentHead = head; 
        while(currentHead != null){
            listValues.add(currentHead.data);
            currentHead = currentHead.next;
        }
        return listValues;
    }
}
