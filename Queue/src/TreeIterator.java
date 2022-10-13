import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {

  public static Queue queue;

    public TreeIterator() {
        queue = new Queue(BinaryTree.root, null);
    }
    
    @Override
    public boolean hasNext() {
      return !queue.checkEmpty();
    }

    @Override
    public Integer next() {
      if (!hasNext())
        return null;
      
      if (queue.head.item.left != null)
        queue.add(queue.head.item.left);
      
      if (queue.head.item.right != null)
        queue.add(queue.head.item.right);

      return queue.remove().value;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
}