import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Resolution " + access(1000) + " ns");
    }

    private static double access(int n){
        int k = 1_000_000;
        int l = n;

        Random rnd = new Random();

        int[] indx = new int[l];

        for(int i = 0; i < n; i++){
        indx[i] = rnd.nextInt(n);
        }

        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = i;
        }

        int sum = 0;
        long t0 = System.nanoTime();
        for(int j = 0; j < k; j++){
            for(int i = 0; i < l; i++){
               sum += array[indx[i]];
            }
        }
        long t_access = (System.nanoTime() - t0);

        t0 = System.nanoTime();

        int dummy = 0;
        for(int j = 0; j < k; j++){
            for(int i = 0; i < l; i++){
                dummy += 1;
            }
        }
        long t_dummy = (System.nanoTime() - t0);

        return ((double)(t_access - t_dummy))/((double)k*(double)l);   
    }
}
