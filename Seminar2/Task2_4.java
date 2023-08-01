package Seminar2;

import java.util.Arrays;

public class Task2_4 {
    // 1.
    // После успешной сортировки массива на нем можно использовать бинарный
    // поиск. Необходимо реализовать алгоритм бинарного поиска по
    // элементам.
    // 2.
    // Стоит акцентировать внимание, что т.к. алгоритм использует подход
    // «разделяй и властвуй», его удобно писать с помощью рекурсии.
    // 3.
    // Так что стоит акцентировать внимание на алгоритмическую сложность
    // данного алгоритма, что его выполнение многократно быстрее простого
    // перебора на больших массивах

    public static void main(String[] args) {
        int[] myArr = { 1, 4, 6556, 776, 77, 87, 5, 66, };
        System.out.println(Arrays.toString(myArr));
        Task2_3.quickSort(myArr, 0, myArr.length - 1);
        System.out.println(Arrays.toString(myArr));
        System.out.println(binarySearch(6556, myArr, 0, myArr.length - 1));
    }

    public static int binarySearch(int value, int[] array, int min, int max) {
        int midpoint;
        if (max < min) {
            return -1;
        }
        else {
            midpoint = (max - min) / 2 + min;
        }

        if (array[midpoint] < value) {
            return binarySearch(value, array, midpoint + 1, max);
        } else {
            if (array[midpoint] > value) {
                return binarySearch(value, array, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }
    }

}
