import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    
    private BinaryTree.Node next;

    public TreeIterator() {
        next = BinaryTree.root;
        while (next != null){
            BinaryTree.stack.push(next);
            next = next.left;
        }
    }
    
    @Override
    public boolean hasNext() {
       return !LinkedList.checkEmpty(BinaryTree.stack);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        
        BinaryTree.Node current = BinaryTree.stack.pop();
        while (current.right != null) {
            BinaryTree.stack.push(current.right);
            current.right = current.right.left;
        }
        return current.value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}