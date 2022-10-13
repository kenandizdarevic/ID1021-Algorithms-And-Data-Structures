public class Bench {
    public static void main(String[] args){
      ArrayQueue queue = new ArrayQueue();
      queue.createArray(10);
      queue.add(15);
      queue.add(20);
      queue.add(25);
      queue.add(30);
      queue.add(35);
      queue.add(35);
      queue.add(35);
      queue.add(35);
      queue.add(35);
      queue.add(145);
      
      queue.remove();
      queue.remove();
      queue.remove();
      queue.remove();
      
    
      queue.add(75);
      queue.add(65);
      queue.add(54);
      queue.add(43);
      queue.add(54);
      queue.add(43);
      queue.add(54);
      queue.add(43);
      queue.add(54);
      queue.add(43);
      queue.add(54);
      queue.add(43);
      queue.add(54);
      queue.add(43);

     
      
  
      System.out.println("--QUEUE--");
      queue.printArray();
      System.out.println("----------");
      
      System.out.println();
      

  
    }
}
