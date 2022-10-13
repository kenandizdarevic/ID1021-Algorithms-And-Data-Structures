import java.util.Iterator;

public class BinaryTree implements Iterable<Integer>{

public static LinkedList stack = new LinkedList(null, null);

    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }
   
    public class Node{
        public Integer key;
        public Integer value;
        
        public Node left, right;

        public Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public void BinaryTree(){
            root = null;
        }

        /**
         * Adds a new leaf to the tree
         * @param key used to sort the tree based on keys
         * @param value in the node
         */
        public void add (Integer key, Integer value){
            Node current = this;

            if (key > current.key){
                if (current.right == null){
                    current.right = new Node(key, value);
                }
                else{
                    current = current.right;
                    current.add(key, value);
                }
            }
            else if (key < current.key){
                if (current.left == null){
                    current.left = new Node(key, value);
                }
                else{
                    current = current.left;
                    current.add(key, value);
                }
            }
            else{
                current.value = value;
            }
        }
    
        /**
         * Finds value at a given key
         * @param key to find value at
         * @return value found
         */
        public Integer lookup (Integer key){
            Node current = this;

            if (key > current.key){
               if (current.right == null){
                    return null;
               }
               else{
                    current = current.right;
                    return current.lookup(key);
               }
            }
            
            else if (key < current.key){
                if (current.left == null){
                    return null;
                }
               else{ 
                    current = current.left;
                    return current.lookup(key);
               }
            }

            else if(key == current.key){
                return current.value;
            }

            else{
                return null;
            }
        }

        /**
         * Prints out the binary tree from left
         */
        public void print(){
            if (left != null){
                left.print();
            }
            System.out.println(" Key: " + key + "\tValue: " + value);
            if (right != null){
                right.print();
            }
        }
    }

    static Node root;
    
    /**
     * Adds root, else calls add
     * @param key to be added
     * @param value to be added
     */
    public void add (Integer key, Integer value){
        if (root == null){
            root = new Node(key, value);
        }
        else{
            root.add(key, value);
        }
    }

    /**
     * Calls for lookup
     * @param key to find value at
     * @return
     */
    public Integer lookup (Integer key){
        return root.lookup(key);
    }
}
