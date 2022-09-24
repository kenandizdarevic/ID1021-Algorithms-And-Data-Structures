
import java.util.Random;

public class LinkedList {
    int head;
    LinkedList tail;

    public static LinkedList stack = LinkedList.generateRandomList(4);

    public LinkedList(int item, LinkedList list ){
        head = item;    // data
        tail = list;    // next
    }

    public int head(){
        return this.head;
    }

    public LinkedList tail(){
        return this.tail;
    }

    /**
     * Appends a list to a list
     * @param toBeAppended list to be appended at the end
     */
    public void append(LinkedList toBeAppended){
        LinkedList next = this;
        while(next.tail != null){
            next = next.tail;
        }
        next.tail = toBeAppended;
    }

    /**
     * Prints out linked list in console
     * @param list to be printed
     */
    public static void printList(LinkedList list){
        while(list.tail != null){
            System.out.println(list.head);
            list = list.tail;
        }
        System.out.println(list.head);
    }

   /**
    * Generates a random linked list of a fixed size
    * @param size of the list
    * @return randomized linked list
    */ 
   public static LinkedList generateRandomList(int size){
        LinkedList randomList = new LinkedList(0, null);
        
        Random rnd = new Random();
        for(int i = 0; i < size; i++){
            LinkedList value = new LinkedList(rnd.nextInt(size), null);
            randomList.append(value);
        }
        
        return randomList;
   }

   /**
    * Append two arrays
    * @param appendTo array to append to
    * @param arrayToAppend to append at the end
    */
   public static void apppendArray(int[] appendTo, int[] arrayToAppend){
        int totalSize = appendTo.length + arrayToAppend.length;

        int[] appended = new int[totalSize];
        for(int i = 0; i < totalSize; i++){
            if(i < appendTo.length) {appended[i] = appendTo[i]; }
            else { appended[i] = arrayToAppend[i - appendTo.length]; }
        }
   }

   /**
    * Generate a random array with size, populate with random number
    * @param size of the array
    * @return randomly populated array
    */
   public static int[] generateRandomArray(int size){
        int[] randomArray = new int[size];
        Random rnd = new Random();
        for(int i = 0; i < size; i++){
            randomArray[i] = rnd.nextInt(size);
        }
        return randomArray; 
   }

   /* STACK */

   public void push(int value){
       stack = new LinkedList(value, stack); 
   }

   public int pop(){
       int value = stack.head;
       stack = stack.tail;
       return value;
   }

    /**
     * Benchmark different linked lists
     * @param tries to get better average result
     * @param size of linked list
     */
    public static void bench(int tries, int size){

        double min = Double.POSITIVE_INFINITY;
        double max = 0; 
        double sum = 0;    

        for(int i = 0; i < tries; i++){

            int[] varyingArray = generateRandomArray(size);
            int[] fixedArray = generateRandomArray(100);
 
            double t0 = System.nanoTime();
            apppendArray(fixedArray, varyingArray);
            double t1 = System.nanoTime();
            double time = t1 - t0;
            
            if(time < min) min = time;
            if(time > max) max = time;

            sum += time;
        }
        System.out.printf("Size: %6d\t Min: %.2fns\t Avg: %.2fns\t Max: %.2fns\n", size, min, (sum/tries), max);
    }

    public static void main(String[] args){
        
       
        printList(stack);
        int popped = stack.pop();
        System.out.println("POPPED VALUE");
        System.out.println(popped);
        System.out.println("--------------------------");
        stack.push(5);
        printList(stack); 
    }
}
