
import java.util.Random;



public class Main {
    // global singly linked list
    public static LinkedList linkyListy = LinkedList.generateRandomLinkedList(4);
    // global doubly linked list
    public static Doubly doublyListy = Doubly.generateRandomDoubly(4);

    public static void main(String[] args){

      /*  printListLink(linkyListy);
       System.out.println("-------------");
       linkyListy.add(123);

       printListLink(linkyListy);
       linkyListy.removeSingly(5);
       System.out.println("-------------");
       printListLink(linkyListy); */

       printList(doublyListy);
       System.out.println("----------------");

       doublyListy.addDoubly(123);
       printList(doublyListy);
       System.out.println("----------------");

       doublyListy.removeDoubly(0);
       printList(doublyListy);   
    }

    /**
     * Prints out doubly linked list
     * @param list doubly to be printed
     */
    public static void printList(Doubly list){
        while(list.next != null){
            System.out.println(list.data);
            list = list.next;
        }
        System.out.println(list.data);
    }

    /**
     * Prints out singly linked list
     * @param list singly to be printed
     */
    public static void printListLink(LinkedList list){
        while(list.next != null){
            System.out.println(list.data);
            list = list.next;
        }
        System.out.println(list.data);
    }

        /**
     * Benchmark different linked lists
     * @param tries to get better average result
     * @param size of linked list
     */
    public static void bench(int tries, int size){

        Random rnd = new Random();

        double min = Double.POSITIVE_INFINITY;
        double max = 0; 
        double sum = 0; 

        int[] sequence = new int[size];

        for(int i = 0; i < size; i++){
            sequence[i] = rnd.nextInt(size - 1);
        }

        for(int i = 0; i < tries; i++){

            double t0 = System.nanoTime();
            
            double t1 = System.nanoTime();
            double time = t1 - t0;
            
            if(time < min) min = time;
            if(time > max) max = time;

            sum += time;
        }
        System.out.printf("Size: %6d\t Min: %.2fns\t Avg: %.2fns\t Max: %.2fns\n", size, min, (sum/tries), max);
    }
    
}
