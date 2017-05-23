/**
 *
 * FASTER THAN ARRAY.SORT IN MOST CASES
 *
 * A sorting algorithm with a runtime that is based on the size of the array,
 * the range of the array data, and the distribution of the data.
 *
 * The increased speed comes at the cost of increased memory usage, however.
 *
 * Good for data without large outliers such as experimental data.
 *
 * @author samuelmcfadden
 *
 * Big O notation is in terms of the number of values in the array (n) and the distribution of the array (d)
 * Runtime: O(n + d)
 */


public class Samusort {

    public static void samusort(int[] array) {

        int min = findMin(array); //O(n)
        int max = findMax(array); //O(n)

        int[] possibleValCount = new int[max-min + 1]; //O(d)

        //Counts the number of each value in the array
        for(int i = 0; i < array.length; i++) { //O(n)
            possibleValCount[array[i] - min] ++;
        }

        int arrayIndex = 0;

        for(int i = 0; i < possibleValCount.length; i++) { //O(d)
            /*
              This for loop will iterate a total of n times.
              It assigns the value of i + min (which is a number that was originally in the array) to its correct position.
            */
            for(int j = possibleValCount[i]; j> 0; j--) {
                array[arrayIndex] = (i + min);
                arrayIndex ++;
            }
        }

    }



    private static int findMin(int[] array) {
        int currentMin = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++) {
            if(array[i] < currentMin) currentMin = array[i];
        }
        return currentMin;
    }

    private static int findMax(int[] array) {
        int currentMax = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > currentMax) currentMax = array[i];
        }
        return currentMax;
    }

}
