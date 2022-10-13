public class ArrayQueue {
    
    public Integer addTo = 1;
    private Integer removeFrom = 0; 
    private boolean wrap = false;
    

    Integer[] queue;

    public void createArray(Integer size){
        queue = new Integer[size];
    }

    /**
     * Adds an element to the queue, uses overlapping
     * @param item to be added
     */
    public void add(Integer item){
        if ((addTo == queue.length) && !wrap){
            queue[addTo - 1] = item;
            wrap = true;
            addTo = 0;
        }
        else if(wrap){
            if(addTo < removeFrom){
                queue[addTo] = item;
                addTo++;
            }
            else{
                expandQueue();
                queue[addTo] = item;
                addTo++;
            }    
        }
        else{
            queue[addTo - 1] = item;
            addTo++;
        }
    }


    /**
     * Removes an element from the queue, with respect to overlapping
     * @return removed element
     */
    public Integer remove(){
        if((removeFrom == queue.length) && wrap){
            removeFrom = 0;
        }
        Integer value = queue[removeFrom++];
        queue[removeFrom - 1] = null;

        if(wrap && (removeFrom == addTo)){
            wrap = false;
            addTo = 1;
            removeFrom = 0;
        }
        return value;
    }

    public void printArray(){
        for (int i = 0; i < queue.length; i++){
            System.out.println(queue[i]);
        }
    }

    public Integer[] expandQueue(){
        Integer[] expanded = new Integer[queue.length * 2];
        for(int i = 0; i < queue.length; i++){
            expanded[i] = remove();
        }
        for (int i = 0; i < expanded.length; i++){
            if (expanded[i] == null){
                addTo = i;
                break;
            }
        }
        removeFrom = 0;
        queue = expanded;
        wrap = false;
        return queue;
    }
}
