import java.util.Random;

public class Sort {
    public static void main(String[] args) throws Exception {
        int[] sizes = {200, 300, 400, 500, 600, 700, 800, 900, 1000, 1200, 1400, 
                       1600, 2000, 3200, 4000, 6400, 7000, 8000, 9000, 10000, 12800, 
                       15000, 16000, 20000, 25600, 100000, 250000, 500000, 10000000, 
                       13000000, 14000000, 15000000, 16000000, 64000000};
        
        for(int size : sizes){ 
            bench(1000, size);
        }
    }

    /**
     * Benchmark different types of arrays
     * @param tries amount of tries
     * @param size size of array
     */
    public static void bench(int tries, int size){

        Random rnd = new Random();

        double min = Double.POSITIVE_INFINITY;
        double max = 0; 
        double sum = 0;
        int random = rnd.nextInt(size);

        int[] unsorted = new int[size];

        for(int i = 0; i < size; i++){
            unsorted[i] = rnd.nextInt();
        }

        for(int i = 0; i < tries; i++){
            double t0 = System.nanoTime();
            insertionSort(unsorted);
            double t1 = System.nanoTime();
            double time = t1 - t0;

            if(time < min)
                min = time;
            if(time > max)
                max = time;

            sum += time;
        }
        System.out.printf("Size: %6d\t Min: %.2fns\t Avg: %.2fns\t Max: %.2fns\n", size, min, (sum/tries), max);
    }

    /**
     * Selcetion sort
     * @param unsorted array
     * @return sorted array
     */
    public static int[] selectionSort(int[] unsorted){
        int temp = 0;

        for(int i = 0; i < unsorted.length - 1; i++){
            int candidate = i;
            for(int j = i; j < unsorted.length; j++){
                if(unsorted[j] < unsorted[candidate])
                    candidate = j;
            }
            temp = unsorted[i];
            unsorted[i] = unsorted[candidate];
            unsorted[candidate] = temp;
        }
        return unsorted;
    }

    /**
     * Insertion sort
     * @param unsorted array
     * @return sorted array
     */
    public static int[] insertionSort(int[] unsorted){
        for(int i = 1; i < unsorted.length; i++){
            int temp = unsorted[i];

            for(int j = i - 1; j > 0 && temp < unsorted[j]; j--){
                unsorted[i] = unsorted[j];
                unsorted[j] = temp;
            }
        }
        return unsorted;
    }

    /**
     * Merge sort
     * @param unsorted
     */
   public static void mergeSort(int[] unsorted){
        if(unsorted.length == 0)
        return;
        int[] tempArray = new int[unsorted.length];
        sort(unsorted, tempArray, 0, (unsorted.length - 1));
   }

   /**
    * Recursive sort which will be used in mergeSort
    * @param unsorted array
    * @param tempArray temporary array to fill with values
    * @param low first array index
    * @param high last array index
    */
   private static void sort(int[] unsorted, int[] tempArray, int low, int high){

    if(low != high){
        int mid = low + (high - low)/2;
        // sort items from low to mid
        sort(unsorted, tempArray, low, mid);

        // sort the items from mid+1 to high
        sort(unsorted, tempArray, (mid + 1), high);

        //merge the sections using the additional array
        merge(unsorted, tempArray, low, mid, high);
    }
   }

   /**
    * Merges two arrays and sorts them
    * @param unsorted array
    * @param tempArray to put the elements
    * @param low first index
    * @param mid middle index
    * @param high last index
    */
   private static void merge(int[] unsorted, int[] tempArray, int low, int mid, int high){

    // copy all itmes from low to high from unsorted to tempArray
    for(int i = 0; i < unsorted.length; i++){
        tempArray[i] =  unsorted[i];
    }

    // do the merging
    int i = low;    // the index in the first part
    int j = mid + 1; // the index in the second part

    // for all indeces from low to high
    for(int k = low; k <= high; k++){

        if(i > mid){
            unsorted[k] = tempArray[j++];
        }

        else if(j > high){
            unsorted[k] = tempArray[i++];
        }

        else if(tempArray[i] < tempArray[j]){
            unsorted[k] = tempArray[i++];
        }

        else{
            unsorted[k] = tempArray[j++];
        }
    }
  }
}
