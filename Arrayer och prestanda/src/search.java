import java.util.Random;

public class search {
    public static void main(String[] args) throws Exception{
        System.out.println("Resolution " + search(2000) + " ns");
    }

    public static double search(int n){

        int m = 10000;
        int k = 1000;

        double t_total = 0;

        Random rnd = new Random();

        int[] keys = new int[m];
        int[] array = new int[n];
       
        int sum = 0;
        for(int j = 0; j < k; j++){
            for(int i = 0; i < n; i++){
                array[i] = rnd.nextInt(10*n);
            }
            for(int i = 0; i < m; i++){
                keys[i] = rnd.nextInt(10*n);
            }
            long t0 = System.nanoTime();
            for(int ki = 0; ki < m; ki++){
             int key = keys[ki];
                for(int i = 0; i < n; i++){
                 if(array[i] == key){
                       sum++;
                       break;
                    }
                }
            }
        
        t_total += (System.nanoTime() - t0)/(m*k);
        }
        return t_total;
    }
}
