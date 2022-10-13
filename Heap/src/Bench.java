import java.util.Random;

public class Bench {
    public static void main(String[] args){
        ArrayHeap heap = new ArrayHeap();
        
        heap.add(12);
        heap.add(7);
        heap.add(6);
        heap.add(10);
        heap.add(8);
        heap.add(20);
        heap.add(5);

        heap.printHeap();
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        heap.printHeap();

    }

   
}
