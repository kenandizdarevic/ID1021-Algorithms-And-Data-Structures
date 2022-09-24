import java.util.Random;

public class Doubly {
    public static Doubly doubleLinked = new Doubly(1, null, null);

    int data;
    Doubly next;
    Doubly prev;

    public Doubly(int value, Doubly nextNode, Doubly previousNode){
        prev = previousNode;
        data = value;
        next = nextNode;
    }

    /**
     * Removes element from doubly linked list
     * @param index to be removed at
     * @param toBeRemoved list to be removed from
     */
    public void removeDoubly(int index){
        Doubly removeFrom = this;
        if(index == 0){
            Main.doublyListy = Main.doublyListy.next;
            Main.doublyListy.prev = null;
        }
       
        else{
            for(int k = 0; k < index - 1; k++){
                // traverse through the list
                removeFrom = removeFrom.next;
                removeFrom.prev = removeFrom.next.prev;
            }
            // remove last index
            if(removeFrom.next.next == null){
                removeFrom.next = null;
                removeFrom.prev = null;
            }
            // remove index elsewhere
            else{
                removeFrom.next = removeFrom.next.next;
                removeFrom.next.prev = removeFrom;
            }
        }
    }
    
    /**
     * Adds a node to the beginning of the doubly
     * @param value to be added
     */
    public void addDoubly(int value){
        Main.doublyListy = new Doubly(value, Main.doublyListy, null);
    }

    /**
     * Append doubly to doubly
     * @param toBeAppended doubly to append
     */
    public void appendDoubly(Doubly toBeAppended){
        Doubly nxt = this;
        while(nxt.next != null){
            nxt = nxt.next;
        }
        nxt.next = toBeAppended;
    }

    /**
     * Generate random doubly linked list 
     * @param size of doubly linked list
     * @return randomized doubly linked list
     */
    public static Doubly generateRandomDoubly(int size){
        Doubly randomDoubly = new Doubly(0, null, null);

        Random rnd = new Random();
        for(int i = 0; i < size; i++){
            Doubly value = new Doubly(rnd.nextInt(size), null, randomDoubly.prev);
            randomDoubly.appendDoubly(value);
        }
        
        return randomDoubly;
    }
}
