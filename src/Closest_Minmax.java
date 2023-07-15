import java.util.Scanner;

public class Closest_Minmax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int iterator = 0; iterator < size; iterator++) {
            array[iterator] = scanner.nextInt();
        }
        System.out.println(closest_minmax(array, size));
    }

    static int closest_minmax(int[] array, int size) {
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;
        int latestMinIndex = -1;
        int latestMaxIndex = -1;
        for (int element : array){
            maxElement = Math.max(element,maxElement);
            minElement = Math.min(element,minElement);
        }
        int count = Integer.MAX_VALUE;
        for (int iterator = 0 ; iterator < size ; iterator++){
            if (array[iterator] == maxElement){
                latestMaxIndex = iterator;
                if (latestMinIndex >= 0){
                    count = Math.min(Math.abs(iterator - latestMinIndex )+ 1,count);
                }
            }
            if (array[iterator] == minElement){
                latestMinIndex = iterator;
                if (latestMaxIndex >= 0){
                    count = Math.min(Math.abs(iterator - latestMaxIndex )+ 1,count);
                }
            }
        }
        return count;

    }
}
