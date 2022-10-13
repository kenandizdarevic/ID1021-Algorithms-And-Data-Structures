import java.lang.NullPointerException;

public class Queue {
    Node head; // item to remove
    Node tail; // added item

    public class Node {
        public BinaryTree.Node item;
        public Node next;

        public Node(BinaryTree.Node item, Node list) {
            this.item = item;
            this.next = list;
        }
    }
    /**
     * Initialize queue
     * @param firstIn first item in the queue
     */
    public Queue(BinaryTree.Node data, Node list) {
        head = new Node(data, null);
    }

    /**
     * Add item to the queue
     * @param item to be added
     */
    public void add(BinaryTree.Node item) {
        if (head.next == null) {
            tail = new Node(item, null);
            head.next = tail;
        }
        else {
            tail.next = new Node(item, null);
            tail = tail.next;
        }
    }

    /**
     * Remove item from queue
     * @return removed item
     */
    public BinaryTree.Node remove() throws NullPointerException {
        if (head == null) {
            throw new NullPointerException("Queue is empty!");
        }
        else {
            BinaryTree.Node data = head.item;
            head = head.next;
            return data;
        }
    }

    /**
     * Prints out the queue
     * @throws NullPointerException
     */
    public void printQueueList() throws NullPointerException {
        Node queue = head;
        if (head == null) {
            throw new NullPointerException("Can not print, queue empty!");
        }

        else{
            while (queue.next != null) {
                System.out.println("[" + queue.item.value + "]");
                queue = queue.next;
            }
            System.out.println("[" + queue.item.value + "]");
        }
    }

    /**
     * Check if queue is empty
     * @return boolean
     */
    public boolean checkEmpty(){
        return head == null;
    }
}
