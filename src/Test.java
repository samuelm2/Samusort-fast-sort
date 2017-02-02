/**
 * Created by samuelmcfadden on 2/1/17.
 */


import java.util.Arrays;
/**
 * comparing Samusort with Arrays.sort.
 * Samusort seems to end up being about faster on random data with large data sets, but runs the system out of memory at around .
 * @author samuelmcfadden
 *
 */
public class Test {

    public static void main(String [] args) {
        System.out.println("Generating array...");
        int[] test = genRandomArrayRange(100000000, 1, 100000);
        int[] test2 = Arrays.copyOf(test, test.length);
        System.out.println("Done generating array.");
        //System.out.println(Arrays.toString(test));

        double x = System.currentTimeMillis();
        Samusort.samusort(test);
        double y = System.currentTimeMillis();
        //System.out.println(Arrays.toString(test));
        System.out.println("Time for Samusort: " + (y-x) + " ms");

        double m = System.currentTimeMillis();
        Arrays.sort(test2);
        double t = System.currentTimeMillis();
        System.out.println("Time for Arrays.sort(): " +(t-m) + " ms");


    }

    /**
     * Generates an array of ints.
     * @param length: size of the array
     * @param lower: Lower bound of the values
     * @param upper: Upper bound of the values
     * @return the generated array
     */
    public static int[] genRandomArrayRange(int length, int lower, int upper) {
        int[] result = new int[length];
        for(int i = 0; i<length; i++) result[i] = (int)(Math.random() * (upper - lower)) + lower ;
        return result;
    }
}



