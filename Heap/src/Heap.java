public class Heap {
    Node root;

    public Heap(){
        root = null;
    }

    public class Node {
        public int branches;
        public Integer data;
        public Node left, right;

        public Node(Integer data) {
            this.data = data;
            this.left = this.right = null;
        }

        /**
         * Adds values to binary-heap
         * @param value to be added
         */
        public void add(Integer value) {
            Node current = this;
            current.branches++;
            Integer holder = null;

            if (current.data > value) {
                holder = current.data;
                current.data = value;
            }
            else{
                holder = value;
            }

            if (current.left == null) {
                current.left = new Node(holder);
            }

            else if (current.right == null) {
                current.right = new Node(holder);
            }
            // if there are more nodes to the left, add to the right
            else if (current.right.branches < current.left.branches) {
                current.right.add(value);
            }
            // if there are more nodes to the right, add to the left
            else {
                current.left.add(value);
            }
        }
        
        /**
         * Removes the node with highest priorty from binary-heap
         * @return value with highest priority
         */
        public Node remove() {
            Node current = this;
            if (current.left == null) {
                return current.right;
            }
            else if (current.right == null) {
                return current.left;
            }
            else if (current.right.data > current.left.data) {
                current.data = current.left.data;
                current.branches--;
                
                if (current.branches == 0) {
                    current.left = null;
                }
                else {
                    current.left = current.left.remove();
                }
                return current;
            }
            else {
                current.data = current.right.data;
                current.branches--;

                if (current.right.branches == 0) {
                    current.right = null;
                }
                else {
                    current.right = current.right.remove();
                }
                return current;
            }
        }
    
        public void push(Integer increment) {
            Node current = this;
            Integer holder = null;
            current.data += increment;

            if (current.left == null && current.right == null) {
                current.data = current.data;
            } 
            else if (current.left != null && current.left.data < current.data) {
                if (current.right != null && current.right.data < current.left.data) {
                    holder = current.right.data;
                    current.right.data = current.data;
                    current.data = holder;
                    current.right.push(0);
                } 
                else {
                    holder = current.left.data;
                    current.left.data = current.data;
                    current.data = holder;
                    current.left.push(0);
                }
            } 
            else if (current.right != null && current.right.data < current.data) {
                if (current.left != null && current.left.data < current.right.data) {
                    holder = current.left.data;
                    current.left.data = current.data;
                    current.data = holder;
                    current.left.push(0);
                } 
                else {
                    holder = current.right.data;
                    current.right.data = current.data;
                    current.data = holder;
                    current.right.push(0);
                }
            } 
        }
    }

    /**
     * Adds nodes to binary-heap, uses Node.add()
     * @param value to be added
     */
    public void add(Integer value) {
        if (root == null){
            root = new Node(value);
            root.branches++;
        }
        else {
            root.add(value);
        }
    }

    /**
     * Removes node with highest priority, uses Node.remove()
     * @return value with highest priority
     */
    public Node remove() {
        if (root == null) {
            return null;
        }
        else if (root.branches == 1) {
            Node removed = root;
            root = null;
            return removed;
        }
        else {
            return root.remove();
        }
    }

    public void push(Integer increment) {
        if (root == null){
            return;
        }
        else {
            root.push(increment);
        }
    }
}
  