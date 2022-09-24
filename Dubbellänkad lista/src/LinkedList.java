import java.util.Random;

public class LinkedList {
    public static LinkedList linked = new LinkedList(0, null);

    int data;
    LinkedList next;

    public LinkedList(int value, LinkedList nextNode){
        data = value;
        next = nextNode;
    }
    
    /**
     * Adds a node to linked list
     * @param value to be added
     * @param addTo LinkedList to add to
     */
    public void addSingly(int value){
        Main.linkyListy = new LinkedList(value, Main.linkyListy);
    }
    
    /**
     * Removes node at specified index
     * @param index to remove node at
     */
    public void removeSingly(int index){
        LinkedList removeFrom = this;
       // exception if we remove the first index
       if(index == 0){
            Main.linkyListy = Main.linkyListy.next;
       }
       else{
        for(int k = 0; k < index - 1; k++){
            // traverse through the list
            removeFrom = removeFrom.next;
            }
         removeFrom.next = removeFrom.next.next;
      }            
    }
    /**
     * Appends a list to the end of a list
     * @param toBeAppended list to be appended
     */
    public void append(LinkedList toBeAppended){
        LinkedList nxt = this;
        while(nxt.next != null){
            nxt = nxt.next;
        }
        nxt.next = toBeAppended;
    }

    /**
     * Generates random singly linked list
     * @param size of the linked list
     * @return randomized linked list
     */
    public static LinkedList generateRandomLinkedList(int size){
        LinkedList randomList = new LinkedList(0, null);
        
        Random rnd = new Random();
        for(int i = 0; i < size; i++){
            LinkedList value = new LinkedList(rnd.nextInt(size), null);
            randomList.append(value);
        }
        
        return randomList;
   }
}
