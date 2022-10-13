public class LinkedList {
    Node head;
    Node last;

    public class Node {
        public Integer data;
        public Node next;

        public Node(Integer data, Node list){
            this.data = data;
            this.next = list;
        }
    }

    /**
     * Prints out list
     */
    public void printList() {
        Node list = head;
        while (list.next != null) {
            System.out.print("[" + list.data + "] ");
            list = list.next;
        }
        System.out.print("[" + list.data + "]");
    }
    
    /**
     * Adds new node as head
     * @param data to be added
     */
    public void addFirst(Integer data) {
        if (head == null) {
            head = new Node(data, null);
        }
        else{
            Node toAdd = new Node(data, head);
            head = toAdd;
        }
    }

    /**
     * Removes the smallest number from the list
     * @return smallest number from list
     */
    public Integer removeTraverse() {
       Node list = head;
       Node previous = null;
       Node min = head;

        while (list.next != null) {
            if (list.next.data < min.data) {
                previous = list;
                min = list.next;
            }
            list = list.next;
        }

        if (min.data == head.data) {
            head = head.next;
        }
        else{
            previous.next = min.next;
        }

        return min.data;
    }

    /**
     * Adds nodes sorted to list
     * @param data to be added
     */
    public void addSorted(Integer data) {
        Node toBeAdded = new Node(data, null);
        Node addTo = head;
        
        if (head == null || toBeAdded.data < head.data){
            toBeAdded.next = head;
            head = toBeAdded;
        }
        else {
            while (addTo.next != null && addTo.next.data < toBeAdded.data) {
                addTo = addTo.next;
            }
            
            toBeAdded.next = addTo.next;
            addTo.next = toBeAdded;
        }
    }

    /**
     * Removes head-node from list
     * @return head-node
     */
    public Integer removeFirst(){
        Node value = head;
        head = head.next;
        return value.data;
    }
}
