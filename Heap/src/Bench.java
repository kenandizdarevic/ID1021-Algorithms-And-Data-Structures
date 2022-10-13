public class Bench {
    public static void main(String[] args){
       /*Heap heap = new Heap();
        heap.add(10);
        heap.add(8);
        heap.add(9);
        heap.add(60);
        heap.add(69);
        
        System.out.println("     " + heap.root.data);
        System.out.print("  " + heap.root.left.data);
        System.out.println( "      "+heap.root.right.data);
        System.out.print(heap.root.left.left.data);
        System.out.print( "      " + heap.root.right.left.data);
        
        heap.push(80);

        System.out.println("         \n");
       
        System.out.println("     " + heap.root.data);
        System.out.print("  " + heap.root.left.data);
        System.out.println( "      "+heap.root.right.data);
        System.out.print(heap.root.left.left.data);
        System.out.print( "      " + heap.root.right.left.data);*/

        ArrayHeap heap = new ArrayHeap();

        heap.add(12);
        heap.add(7);
        heap.add(6);
        heap.add(10);
        heap.add(8);
        heap.add(67);
        heap.add(8100);
        heap.add(123);
        heap.add(3);
        heap.add(47);
        heap.add(58);
        heap.add(54);
        //heap.add(1);
        
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
       
        
        
        

    }
}
