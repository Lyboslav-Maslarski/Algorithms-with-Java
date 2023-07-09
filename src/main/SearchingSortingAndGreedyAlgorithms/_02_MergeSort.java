package SearchingSortingAndGreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _02_MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        mergeSort(array);

        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int firstArrLength = array.length / 2;
        int secondArrLength = array.length - firstArrLength;

        int[] firstArr = new int[firstArrLength];
        int[] secondArr = new int[secondArrLength];

        System.arraycopy(array, 0, firstArr, 0, firstArrLength);

        if (array.length - firstArrLength >= 0)
            System.arraycopy(array, firstArrLength, secondArr, 0, array.length - firstArrLength);

        mergeSort(firstArr);
        mergeSort(secondArr);

        int mainIndex = 0;
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstArrLength && secondIndex < secondArrLength) {
            if (firstArr[firstIndex] < secondArr[secondIndex]) {
                array[mainIndex] = firstArr[firstIndex];
                mainIndex++;
                firstIndex++;
            } else {
                array[mainIndex] = secondArr[secondIndex];
                mainIndex++;
                secondIndex++;
            }
        }

        while (firstIndex < firstArrLength) {
            array[mainIndex] = firstArr[firstIndex];
            mainIndex++;
            firstIndex++;
        }

        while (secondIndex < secondArrLength) {
            array[mainIndex] = secondArr[secondIndex];
            mainIndex++;
            secondIndex++;
        }

        return array;
    }
}