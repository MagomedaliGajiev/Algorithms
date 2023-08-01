package Seminar2;
public class Task2_2 {
    // Написать алгоритм быстрого поиска ( quicksort)quicksort).

    public static void main(String[] args) {
        int[] myArr = { 1, 4, 6556, 776, 77, 87, 5, 66, };
        for (int i : myArr) {
            System.out.print(i + " ");
        }
        quickSort(myArr, 0, myArr.length - 1);
        System.out.println();
        for (int i : myArr) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        int leftPosition = start;
        int rightPosition = end;
        int pivot = array[(start + end) / 2];

        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);

        if (leftPosition < end) {
            quickSort(array, leftPosition, end);
        }
        if (start < rightPosition) {
            quickSort(array, start, rightPosition);
        }
    }
}
