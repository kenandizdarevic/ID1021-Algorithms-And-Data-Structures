public class LinkedList {
    BinaryTree.Node node;
    LinkedList next;

    public LinkedList (BinaryTree.Node leaf, LinkedList list){
        node = leaf;
        next = list;
    }

    public BinaryTree.Node node() {
        return this.node;
    }

    public LinkedList next() {
        return this.next;
    }

    public void push(BinaryTree.Node value){
        BinaryTree.stack = new LinkedList(value, BinaryTree.stack); 
    }
 
    public BinaryTree.Node pop(){
        BinaryTree.Node value = BinaryTree.stack.node;
        BinaryTree.stack = BinaryTree.stack.next;
        return value;
    }
    /**
     * Checks if stack is empty
     * @param stack to be checked
     * @return booelan
     */
    public static boolean checkEmpty(LinkedList stack){
        if (stack.node == null){
            return true;
        }
        else{
            return false;
        }
    }
}
