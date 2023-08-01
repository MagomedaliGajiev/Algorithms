package Seminar2;

import java.util.Date;

public class Task2_3 {
    // 1.
    // Пишем тесты для сравнения производительности сортировки больших
    // массивов.
    // 2.
    // Для наглядного результата стоит сравнивать массивы до 100 000 элементов.
    // При таком подходе будет явно видно, какая из сортировок окажется быстрее.

    public static void main(String[] args) {
        for (int i = 10000; i <= 100000; i += 10000) {
            int[] array = new int[i];
            for (int j = 0; j < array.length; j++) {
                array[j] = (int) (Math.random() * 1000);
            }
            int[] array2 = array;
            Date startDate = new Date();
            bubbleSort(array);
            Date endDate = new Date();
            long bubbleSortDuration = endDate.getTime() - startDate.getTime();

            startDate = new Date();
            quickSort(array2, 0, array2.length - 1);
            endDate = new Date();
            long quickSortDuration = endDate.getTime() - startDate.getTime();

            System.out.printf("i: %s, bubble sort duration: %s, quick sort duration: %s%n", i,
                    bubbleSortDuration, quickSortDuration);
        }
    }

    public static void bubbleSort(int[] array) {
        boolean flag = false; // false - не было обменов, true - был хотя бы 1 обмен

        // на какое место будем ставим наибольший элемент
        for (int i = array.length - 1; i > 0; i--) {
            // проходим по не отсортированной последовательности
            for (int j = 0; j < i; j++) {
                // если порядок элементов неправильный
                if (array[j] > array[j + 1]) {
                    // меняем местами пары
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true; // меняем флажок
                }
            }
            // если значение флага не поменялось
            if (!flag) {
                return; // массив отсортирован. Выходим с функции
            }
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
