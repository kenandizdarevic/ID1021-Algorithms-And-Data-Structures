import java.util.Random;

public class Search {
    public static void main(String[] args) throws Exception {
        int[] sizes = {200, 400, 800, 1600, 3200, 6400, 12800, 25600, 100000, 250000, 500000, 10000000, 13000000, 14000000, 15000000, 16000000, 64000000};

        for(int size : sizes){ 
            bench(1000000, size);
        }
    }

    /**
     * Searchs through an unsorted array
     * @param array where the key is located
     * @param key value to be found in the array
     * @return boolean value if found or not
     */
    public static boolean search_unsorted(int[] array, int key){
        for(int index = 0; index < array.length; index++){
            if(array[index] == key)
                return true;
            
            if(array[index] > key)
                break;
        }
        return false;
    }

    /**
     * Benchmark different types of arrays
     * @param tries amount of tries
     * @param size size of array
     */
    public static void bench(int tries, int size){

        Random rnd = new Random();
        int[] sortedArray = sorted(size);
        int[] sortedArray2 = sorted(size); 

        double min = Double.POSITIVE_INFINITY;
        double max = 0; 
        double sum = 0;
        int random = rnd.nextInt(size);

        for(int i = 0; i < tries; i++){
            double t0 = System.nanoTime();
            binary_search(sortedArray, rnd.nextInt(size*10));
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
     * Sorts an array
     * @param n is the size of the array
     * @return sorted array
     */
    private static int[] sorted(int n){

        Random rnd = new Random();

        int[] array = new int[n];
        int nxt = 0;

        for(int i = 0; i < n; i++){
            nxt += rnd.nextInt(n) + 1;
            array[i] = nxt;
        }
        return array;
    }

    /**
     * Binary search algoritm
     * @param array to be searched through, needs to be sorted
     * @param key to be found in array
     * @return true if found, false if not
     */
   public static boolean binary_search(int[] array, int key){
        int first = 0;
        int last = array.length - 1;

        while(true){
            int index = first +  (last - first)/2;
    
            if(array[index] == key){
                return true;
            }
           if(array[index] < key && index < last){
                first = index + 1;
                continue;
            }
           if(array[index] > key && index > first){
                last = index - 1;
                continue;
            }
            break;
        }
        return false;
    }

   /**
    * Searches for duplicates in two sorted arrays
    * @param arrayKeys the values to be searched for
    * @param arrayFind search for the values in this array
    * @return amount of duplicates found
    */ 
   public static int search_duplicates(int[] arrayKeys, int[] arrayFind){
       
        int duplicates = 0;

        for(int i = 0; i < arrayKeys.length ; i++){

           if(binary_search(arrayFind, arrayKeys[i]))
              duplicates++;
        }
        return duplicates;
   }
   /***
    * Seraches for duplicets by tracking the next element
    * @param arrayKeys the values to be searched for
    * @param arrayFind search for values in this array
    */
   public static void search_duplicates_index(int[] arrayKeys, int[] arrayFind){
        int nextArrayKeys = 0;
        int nextArrayFind = 0;

        for(int i = 0; i < arrayKeys.length; i++){
            if(arrayKeys[nextArrayKeys] > arrayFind[nextArrayFind])
                nextArrayFind++;
        
            else if(arrayKeys[nextArrayKeys] < arrayFind[nextArrayFind])
                nextArrayKeys++;
                
            else if(arrayKeys[nextArrayKeys] == arrayFind[nextArrayFind])
                nextArrayKeys++;
                nextArrayFind++;
                
            if(nextArrayKeys == arrayKeys.length - 1 || nextArrayFind == arrayFind.length - 1)
                break;
        }    
    }
}
