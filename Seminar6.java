package seminar_6;

import java.util.Arrays;
import java.util.Random;

public class Seminar6 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int arrLength = 70;
        int[] array = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            array[i] = rnd.nextInt(-100, 101);
        }
        Arrays.sort(array);
        int searchNumber = rnd.nextInt(-100, 101);

//        int[] array = {-100, -96, -87, -85, -81, -80, -76, -74, -73, -63, -62, -61, -60, -58, -51, -50, -49, -41, -35, -35, -30, -24, -23, -20, -17, -13, 0, 3, 3, 3, 7, 7, 9, 13, 13, 15, 16, 21, 23, 25, 31, 33, 35, 37, 38, 38, 42, 46, 47, 49, 50, 51, 55, 57, 58, 62, 68, 72, 74, 75, 76, 84, 87, 87, 88, 91, 92, 93, 93, 99};
//        int searchNumber = 10;

        System.out.println(Arrays.toString(array));
        System.out.println(searchNumber);
        System.out.println(binarySearch(array, searchNumber));

    }

    public static int binarySearch(int[] array, int searchNumber){

        boolean isSearchEnded = false;
        int result = -1;

        if (array.length == 0) return result;
        if (array.length == 1){
            if (array[0] == searchNumber){
                return 0;
            } else {
                return result;
            }
        }

        int highBorder = array.length;
        int lowBorder = 0;
        int idx = highBorder/2;
        while (!isSearchEnded){
            if (highBorder - lowBorder == 1) {
                isSearchEnded = true;
            }
            if (array[idx] == searchNumber) {
                return idx;
            } else if (array[idx] > searchNumber) {
                highBorder = (lowBorder + highBorder)/2;
                idx = highBorder/2;
            } else if (array[idx] < searchNumber){
                lowBorder = idx;
                idx = (highBorder - lowBorder)/2 + lowBorder;
            }
        }
        return result;
    }
}